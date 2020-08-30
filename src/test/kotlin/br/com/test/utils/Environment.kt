package br.com.test.utils

class Environment {

    companion object {
        private var profile: String = ""

        fun get(): String {
            try {
                if (profile == "") {
                    profile = System.getProperty("profile")
                }
                return profile

            } catch (e: Exception) {
                throw RuntimeException("É obrigatório passar o profile (-Dprofile=ambiente)", e)
            }
        }
    }
}