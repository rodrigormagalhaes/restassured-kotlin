package br.com.test

import br.com.test.utils.Data
import io.restassured.RestAssured
import org.junit.jupiter.api.BeforeAll

abstract class BaseTest {

    companion object {

        @BeforeAll
        @JvmStatic
        fun before() {
            RestAssured.baseURI = Data.url
        }
    }


}