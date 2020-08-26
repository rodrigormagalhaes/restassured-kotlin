package br.com.rodrigo

import io.restassured.module.kotlin.extensions.Given
import io.restassured.module.kotlin.extensions.Then
import io.restassured.module.kotlin.extensions.When
import org.hamcrest.Matchers
import org.junit.jupiter.api.Test

class test {

    @Test
    fun `test restassured with Kotlin`() {

        Given {
            header("Content-type", "application/json; charset=UTF-8")
            body("{\n" +
                    "    \"name\": \"morpheus\",\n" +
                    "    \"jobs\": \"leader\"\n" +
                    "}")
        } When {
            post("https://reqres.in/api/users")
        } Then  {
            statusCode(201)
            body("name", Matchers.equalTo("morpheus"))
            body("jobs", Matchers.equalTo("leader"))
            body("id", Matchers.notNullValue())
            body("createdAt", Matchers.notNullValue())

        }

    }
}