package br.com.test.tests

import br.com.test.request.PaymentRequest
import br.com.test.utils.Data
import br.com.test.utils.bodyField
import io.restassured.RestAssured
import io.restassured.module.kotlin.extensions.Given
import io.restassured.module.kotlin.extensions.Then
import io.restassured.module.kotlin.extensions.When
import org.junit.jupiter.api.Test

class PaymentTest : BaseTest() {

    @Test
    fun `should create payment with success`() {
        RestAssured.baseURI = Data.mockApiUrl
        val request = PaymentRequest().validPayment()

        Given {
            header("Content-type", "application/json; charset=UTF-8")
            body(request)
            log().all()
        } When {
            post("/payments")
        } Then {
            statusCode(201)

            bodyField("paymentId").notNull()
            bodyField("clientId").equalsTo("ACD123")
            bodyField("amount.value").equalsTo(500)
            bodyField("payment.card.number").equalsTo("4532101557982126")
            bodyField("payment.card.holder.name").equalsTo("Teste Teste")

        }
    }

    @Test
    fun `should create payment without clientId with success`() {
        RestAssured.baseURI = Data.mockApiUrl
        val request = PaymentRequest().validPaymentWithoutClientId()

        Given {
            header("Content-type", "application/json; charset=UTF-8")
            body(request)
            log().all()
        } When {
            post("/payments")
        } Then {
            statusCode(201)

            bodyField("paymentId").notNull()
            bodyField("clientId").isNull()
            bodyField("amount.value").equalsTo(500)
            bodyField("payment.card.number").equalsTo("4532101557982126")
            bodyField("payment.card.holder.name").equalsTo("Teste Teste")

        }
    }
}

