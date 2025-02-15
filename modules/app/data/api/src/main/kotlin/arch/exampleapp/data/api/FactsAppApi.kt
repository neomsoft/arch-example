package arch.exampleapp.data.api

import arch.exampleapp.data.api.responses.FactJson
import io.github.neomsoft.httpclient.result.extensions.getSafety
import io.ktor.client.HttpClient
import org.koin.core.annotation.Single

@Single(binds = [FactsAppApi::class])
internal class FactsAppApi(
    private val client: HttpClient = HttpClientProvider().client,
) {

    suspend fun fact() = client.getSafety<FactJson>("$BASE_URL/fact")

    companion object {
        private const val BASE_URL = "https://catfact.ninja"
    }
}