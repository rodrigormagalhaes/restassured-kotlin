package br.com.test.request

import br.com.test.payloads.User
import br.com.test.utils.Data

class UserRequest {

    fun valideUser(): User {
        val userReq = User(
                name = Data.name,
                jobs = Data.jobs
        )
        return userReq
    }
}