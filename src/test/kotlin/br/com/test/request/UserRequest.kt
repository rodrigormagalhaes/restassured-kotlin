package br.com.test.request

import br.com.test.payloads.User

class UserRequest {

    fun valideUser(): User {
        val userReq = User(
                name = "morpheus",
                jobs = "leader"
        )
        return userReq
    }
}