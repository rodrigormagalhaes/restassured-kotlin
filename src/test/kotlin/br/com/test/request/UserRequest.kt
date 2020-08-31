package br.com.test.request

import br.com.test.payloads.User
import br.com.test.utils.Data

class UserRequest {

    fun validUser(): User {
        return User(
                name = Data.name,
                job = Data.job
        )
    }
}