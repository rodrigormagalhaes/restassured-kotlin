package br.com.test.utils

class Environment {

    companion object {
        private var profile: String = ""

        fun get(): String {
            if(profile == "") {
                profile = System.getProperty("profile")
            }
            return profile
        }
    }
}