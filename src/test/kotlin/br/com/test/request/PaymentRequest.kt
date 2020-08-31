package br.com.test.request

import br.com.test.payloads.Amount
import br.com.test.payloads.Card
import br.com.test.payloads.Currency
import br.com.test.payloads.Holder
import br.com.test.payloads.Payment
import br.com.test.payloads.Payments
import br.com.test.payloads.Type
import br.com.test.utils.Data

class PaymentRequest {

    fun validPayment(): Payment {
        return Payment(
                clientId = Data.clientId,
                referenceId = Data.referenceId,
                amount = Amount(
                        value = Data.value.toLong(),
                        currency = Currency.BRL
                ),
                payment = Payments(
                        type = Type.CREDIT_CARD,
                        installments = Data.installments.toInt(),
                        card = Card(
                                number = Data.number,
                                exp_month = Data.exp_month,
                                exp_year = Data.exp_year,
                                cvv = Data.cvv,
                                holder = Holder(
                                        name = Data.holderName
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