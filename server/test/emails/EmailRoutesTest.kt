package org.example.demo.server.emails

import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import io.ktor.http.HttpStatusCode
import io.ktor.server.testing.testApplication
import org.example.demo.server.module
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class EmailRoutesTest {

    @Test
    fun `lists all emails`() = testApplication {
        application { module() }
        val response = client.get("/emails")
        assertEquals(HttpStatusCode.OK, response.status)
        assertTrue(response.bodyAsText().contains(emails.first().subject))
    }

    @Test
    fun `returns a single email`() = testApplication {
        application { module() }
        val response = client.get("/emails/1")
        assertEquals(HttpStatusCode.OK, response.status)
        assertTrue(response.bodyAsText().contains(emails.first { it.id == 1 }.subject))
    }

    @Test
    fun `unknown email is not found`() = testApplication {
        application { module() }
        assertEquals(HttpStatusCode.NotFound, client.get("/emails/999").status)
    }
}
