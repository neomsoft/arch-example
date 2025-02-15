package io.github.neomsoft.httpclient.result.extensions

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.delete
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.put

suspend inline fun <reified T> HttpClient.getSafety(
    urlString: String,
    block: HttpRequestBuilder.() -> Unit = {},
) = Result.runCatching {
    get(urlString = urlString, block = block).body<T>()
}

suspend inline fun <reified T> HttpClient.postSafety(
    urlString: String,
    block: HttpRequestBuilder.() -> Unit = {},
) = Result.runCatching {
    post(urlString = urlString, block = block).body<T>()
}

suspend inline fun <reified T> HttpClient.putSafety(
    urlString: String,
    block: HttpRequestBuilder.() -> Unit = {},
) = Result.runCatching {
    put(urlString = urlString, block = block).body<T>()
}

suspend inline fun <reified T> HttpClient.deleteSafety(
    urlString: String,
    block: HttpRequestBuilder.() -> Unit = {},
) = Result.runCatching {
    delete(urlString = urlString, block = block).body<T>()
}