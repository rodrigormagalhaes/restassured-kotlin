package br.com.test.request

import br.com.test.payloads.Amount
import br.com.test.payloads.Card
import br.com.test.payloads.Currency
import br.com.test.payloads.Holder
import br.com.test.payloads.Payment
import br.com.test.payloads.Payments
import br.com.test.payloads.Type

class PaymentRequest {

    fun validPayment(): Payment {
        return Payment(
                clientId = "ACD123",
                referenceId = "1239878889",
                amount = Amount(
                        value = 500,
                        currency = Currency.BRL
                ),
                payment = Payments(
                        type = Type.CREDIT_CARD,
                        installments = 3,
                        card = Card(
                                number = "4532101557982126",
                                exp_month = "12",
                                exp_year = "2025",
                                cvv = "123",
                                holder = Holder(
                                        name = "Teste Teste"
                                )
                        )
                )
        )
    }

    fun validPaymentWithoutClientId(): Payment {
        val req = validPayment()
        req.clientId = null

        return req
    }
}