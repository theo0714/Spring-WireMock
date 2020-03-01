package com.example.wiremock

import com.example.wiremock.controller.PostRequest
import com.github.tomakehurst.wiremock.WireMockServer
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit.jupiter.SpringExtension

@SpringBootTest
@ExtendWith(SpringExtension::class)
@ActiveProfiles("test")
class BaseSpringTest {
    lateinit var wireMockServer: WireMockServer

    companion object {
        val todoRequest = PostRequest(1, "THEO", "GAMEHUB")
        const val getBody: String = "{\n" +
                "  \"userId\": 1,\n" +
                "  \"id\": 1,\n" +
                "  \"title\": \"delectus aut autem\",\n" +
                "  \"completed\": false\n" +
                "}"

        const val postBody: String = "{ \"id\" : \"1\", \"userId\" : \"1\", \"title\" : \"THEO\", \"body\" : \"GAMEHUB\" }"
        const val commentBody: String = "[{\"postId\" : \"1\", \"id\" : \"1\", \"name\" : \"id labore ex et quam laborum\", \"email\": \"Eliseo@gardner.biz\", \"body\": \"laudantium enim quasi est quidem magnam voluptate ipsam eos tempora quo necessitatibus dolor quam autem quasi reiciendis et nam sapiente accusantium\"}]"
    }
}