package org.example.demo.server

import io.ktor.http.HttpStatusCode
import io.ktor.serialization.kotlinx.json.json
import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import io.ktor.server.plugins.contentnegotiation.ContentNegotiation
import io.ktor.server.plugins.cors.routing.CORS
import io.ktor.server.response.respond
import io.ktor.server.routing.get
import io.ktor.server.routing.routing
import org.example.demo.SERVER_PORT

fun main() {
    embeddedServer(Netty, port = SERVER_PORT, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    install(ContentNegotiation) { json() }
    install(CORS) { anyHost() }

    routing {
        get("/emails") {
            call.respond(emails)
        }
        get("/emails/{id}") {
            val email = emails.find { it.id == call.parameters["id"]?.toIntOrNull() }
            if (email == null) call.respond(HttpStatusCode.NotFound) else call.respond(email)
        }
    }
}
