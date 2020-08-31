package br.com.test.tests

import br.com.test.request.UserRequest
import br.com.test.utils.bodyField
import io.restassured.module.kotlin.extensions.Given
import io.restassured.module.kotlin.extensions.Then
import io.restassured.module.kotlin.extensions.When
import org.junit.jupiter.api.Test

class UserTest : BaseTest() {

    @Test
    fun `should create a user with success`() {
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
            bodyField("job").equalsTo("leader")
            bodyField("id").notNull()
            bodyField("createdAt").notNull()

        }
    }
}

