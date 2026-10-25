package org.example.demo

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json

class MailApi {
    private val client = HttpClient {
        install(ContentNegotiation) { json() }
    }

    suspend fun emails(): List<Email> = client.get("$serverUrl/emails").body()

    suspend fun email(id: Int): Email = client.get("$serverUrl/emails/$id").body()
}
