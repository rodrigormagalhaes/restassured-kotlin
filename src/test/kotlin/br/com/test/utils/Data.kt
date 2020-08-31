package br.com.test.utils

import java.util.Properties

class Data {

    companion object {

        val reqResUrl: String = getProperties("application", "reqres.url")
        val mockApiUrl: String = getProperties("application", "mockapi.url")

        val name: String = getProperties("data", "name")
        val job: String = getProperties("data", "job")

        val clientId: String = getProperties("data", "clientId")
        val referenceId: String = getProperties("data", "referenceId")
        val value: String = getProperties("data", "value")
        val installments: String = getProperties("data", "installments")
        val number: String = getProperties("data", "number")
        val exp_month: String = getProperties("data", "expMonth")
        val exp_year: String = getProperties("data", "expYear")
        val cvv: String = getProperties("data", "cvv")
        val holderName: String = getProperties("data", "holder.name")

        private fun getProperties(parameterType: String, parameterName: String): String {
            val profile: String? = Environment.get()

            val propertyInputStream = this::class.java.classLoader.getResourceAsStream("$parameterType-$profile.properties")

            val property = Properties()
            property.load(propertyInputStream)

            return property.getProperty(parameterName)

        }
    }
}