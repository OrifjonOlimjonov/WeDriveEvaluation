package uz.orifjon.wedrivetask.utils.extensions

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.ServerResponseException
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.delete
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.put
import io.ktor.client.statement.bodyAsText
import io.ktor.http.ContentType
import io.ktor.http.HttpStatusCode
import io.ktor.http.contentType
import io.ktor.http.takeFrom


suspend inline fun <reified T> HttpClient.postJson(
    urlAddress: String,
    block: HttpRequestBuilder.() -> Unit = {}
): T {
    val response = post {
        contentType(ContentType.Application.Json)
        url.takeFrom(urlAddress)
        block()
    }
    if (response.status >= HttpStatusCode.OK || response.status <= HttpStatusCode.MultipleChoices) {
        return response.body()
    } else {
        throw ServerResponseException(response, response.bodyAsText())
    }
}


suspend inline fun <reified T> HttpClient.putJson(
    urlAddress: String,
    block: HttpRequestBuilder.() -> Unit = {}
): T {
    val response = put {
        contentType(ContentType.Application.Json)
        url.takeFrom(urlAddress)
        block()
    }
    if (response.status == HttpStatusCode.OK) {
        return response.body()
    } else {
        throw ServerResponseException(response, response.bodyAsText())
    }
}

suspend inline fun <reified T> HttpClient.getJson(
    urlAddress: String,
    block: HttpRequestBuilder.() -> Unit = {}
): T {
    val response = get {
        contentType(ContentType.Application.Json)
        url.takeFrom(urlAddress)
        block()
    }
    if (response.status == HttpStatusCode.OK) {
        return response.body()
    } else {
        throw ServerResponseException(
            response, try {
                response.bodyAsText()
            } catch (e: Exception) {
                e.toString()
            }
        )
    }
}