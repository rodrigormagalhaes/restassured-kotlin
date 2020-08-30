package br.com.test

import br.com.test.request.UserRequest
import br.com.test.utils.bodyField
import io.restassured.module.kotlin.extensions.Given
import io.restassured.module.kotlin.extensions.Then
import io.restassured.module.kotlin.extensions.When
import org.junit.jupiter.api.Test

class Test : BaseTest() {

    @Test
    fun `test restassured with Kotlin`() {
        val request = UserRequest().validUser()

        Given {
            header("Content-type", "application/json; charset=UTF-8")
            body(request)
            log().all()
        } When {
            post("/api/users")
        } Then {
            statusCode(201)

            bodyField("name").equalsTo("morpheus")
            bodyField("jobs").equalsTo("leader")
            bodyField("id").notNull()
            bodyField("createdAt").notNull()

        }
    }
}

