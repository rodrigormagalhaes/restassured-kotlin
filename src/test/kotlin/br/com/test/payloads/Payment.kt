package br.com.test.payloads

data class Payment(
        var clientId: String?,
        var referenceId: String?,
        var amount: Amount,
        var payment: Payments
)

data class Amount(
        var value: Long,
        val currency: Currency
)

enum class Currency {
    BRL
}

data class Payments(
        var type: Type,
        var installments: Int,
        val card: Card
)

enum class Type {
    CREDIT_CARD
}

data class Card(
        var number: String,
        var exp_month: String,
        var exp_year: String,
        var cvv: String,
        var holder: Holder
)

data class Holder(
        var name: String
)