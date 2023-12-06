package com.AmirHusseinSoori.attackOnTitan.data.network

import io.ktor.client.HttpClient
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.DEFAULT
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.accept
import io.ktor.client.utils.EmptyContent.contentType
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.http.takeFrom
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json


interface AttackOnTitanClient {
    fun getHttpClient(): HttpClient
}

class AttackOnTitanClientImp() : AttackOnTitanClient {
    override fun getHttpClient(): HttpClient = HttpClient {
            // Configure HttpClient settings here
            expectSuccess = true
            install(HttpTimeout) {
                val timeout = 5000L
                connectTimeoutMillis = timeout
//                requestTimeoutMillis = timeout
//                socketTimeoutMillis = timeout
            }
            install(Logging) {
                logger = Logger.DEFAULT
                level = LogLevel.HEADERS
            }
            install(ContentNegotiation) {
                json(Json {
                    ignoreUnknownKeys = true
                    prettyPrint = true
                    isLenient = true
                })
            }
            defaultRequest {
                contentType(ContentType.Application.Json)
                accept(ContentType.Application.Json)
            }
        }



}
