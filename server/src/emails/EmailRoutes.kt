package org.example.demo.server.emails

import io.ktor.http.HttpStatusCode
import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import io.ktor.server.routing.get

fun Route.emailRoutes() {
    get("/emails") {
        call.respond(emails)
    }
    get("/emails/{id}") {
        val email = emails.find { it.id == call.parameters["id"]?.toIntOrNull() }
        if (email == null) call.respond(HttpStatusCode.NotFound) else call.respond(email)
    }
}
