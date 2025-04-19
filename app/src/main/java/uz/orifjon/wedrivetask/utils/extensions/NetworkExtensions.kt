package uz.orifjon.wedrivetask.utils.extensions

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerCollector
import com.chuckerteam.chucker.api.ChuckerInterceptor
import io.ktor.client.HttpClient
import io.ktor.client.HttpClientConfig
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.engine.okhttp.OkHttpConfig
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.header
import io.ktor.http.ContentType
import io.ktor.http.URLBuilder
import io.ktor.http.URLProtocol
import io.ktor.http.Url
import io.ktor.http.contentType
import io.ktor.http.encodedPath
import io.ktor.http.takeFrom
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import uz.orifjon.wedrivetask.BuildConfig
import uz.orifjon.wedrivetask.cache.preferences.UserPreferences


const val NETWORK_TIME_OUT = 6_0000L

fun httpClient(
    context: Context,
    userPreferences: UserPreferences
) =
    HttpClient(OkHttp) {
        expectSuccess = true
        logging()
        json()
        addChucker(context)
        defaultRequest(userPreferences)
        httpTimeOutConfig()
    }

fun HttpClientConfig<OkHttpConfig>.addChucker(
    context: Context
) {
    engine {
        if (BuildConfig.DEBUG) {
            addInterceptor(
                ChuckerInterceptor.Builder(context)
                    .collector(ChuckerCollector(context))
                    .maxContentLength(250_000L)
                    .alwaysReadResponseBody(true)
                    .build()
            )
        }
    }
}

internal fun HttpClientConfig<*>.httpTimeOutConfig() {
    install(HttpTimeout) {
        requestTimeoutMillis = NETWORK_TIME_OUT
        connectTimeoutMillis = NETWORK_TIME_OUT
        socketTimeoutMillis = NETWORK_TIME_OUT
    }
}


internal fun HttpClientConfig<*>.logging() = install(Logging) {
    level = LogLevel.ALL
    logger = object : Logger {
        override fun log(message: String) {
            println("HTTP Client message: $message")
        }
    }
}


internal fun HttpClientConfig<*>.json() = install(ContentNegotiation) {
    json(Json {
        prettyPrint = true
        isLenient = true
        useAlternativeNames = true
        ignoreUnknownKeys = true
        encodeDefaults = true
        explicitNulls = false
    })
}


private fun URLBuilder.withBaseUrl(url: String = BuildConfig.DEV_API_URL): URLBuilder {
    val baseUrl = Url(url)
    val urlBuilder = URLBuilder(baseUrl).apply { encodedPath += this@withBaseUrl.encodedPath }
    return takeFrom(urlBuilder)
}


fun HttpClientConfig<*>.defaultRequest(
    userPreferences: UserPreferences
) =
    install(DefaultRequest) {
        url.protocol = URLProtocol.HTTPS
        url.withBaseUrl()
        header("X-Account-Phone", userPreferences.phoneNumber)
        contentType(ContentType.Application.Json.withParameter("charset", "utf-8"))
    }