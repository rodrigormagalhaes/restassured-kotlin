package br.com.test.utils

import java.util.Properties

class Data {

    companion object {

        val url: String = getProperties("application", "url")

        val name: String = getProperties("data", "name")
        val jobs: String = getProperties("data", "jobs")

        private fun getProperties(parameterType: String, parameterName: String): String {
            val profile: String? = Environment.get()

            val propertyInputStream = this::class.java.classLoader.getResourceAsStream("$parameterType-$profile.properties")

            val property = Properties()
            property.load(propertyInputStream)

            return property.getProperty(parameterName)

        }
    }
}