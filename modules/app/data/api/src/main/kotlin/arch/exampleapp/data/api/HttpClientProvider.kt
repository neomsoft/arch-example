package arch.exampleapp.data.api

import arch.exampleapp.data.api.responses.ErrorJson
import io.ktor.client.HttpClient
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.HttpResponseValidator
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.statement.bodyAsText
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

internal class HttpClientProvider {

    private val json = Json {
        ignoreUnknownKeys = true
    }

    val client = HttpClient {
        install(ContentNegotiation) {
            json(json)
        }

        expectSuccess = true

        HttpResponseValidator {
            handleResponseException { exception, _ -> handleException(exception) }
        }
    }

    private suspend fun handleException(exception: Throwable) {
        val clientException = exception as? ClientRequestException ?: return
        val exceptionResponse = clientException.response
        val exceptionResponseText = exceptionResponse.bodyAsText()
        val errorJson = json.decodeFromString<ErrorJson>(exceptionResponseText)

        throw RuntimeException(errorJson.message)
    }
}