package br.com.test.utils

import io.restassured.response.ValidatableResponse
import org.hamcrest.Matchers

data class PreValidatableResponse(
        private val bodyField: String,
        private val validatableResponse: ValidatableResponse
) {
    fun <T> equalsTo(other: T) {
        validatableResponse.body(bodyField, Matchers.`is`(other))
    }

    fun notNull() {
        validatableResponse.body(bodyField, Matchers.notNullValue())
    }

    fun isNull() {
        validatableResponse.body(bodyField, Matchers.nullValue())
    }
}

fun ValidatableResponse.bodyField(field: String) = PreValidatableResponse(
        bodyField = field,
        validatableResponse = this
)