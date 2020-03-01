package com.example.wiremock.test.service

import com.example.wiremock.BaseSpringTest
import com.example.wiremock.client.PostClient
import com.example.wiremock.controller.PostRequest
import com.example.wiremock.service.PostService
import com.github.tomakehurst.wiremock.WireMockServer
import com.github.tomakehurst.wiremock.client.WireMock
import com.github.tomakehurst.wiremock.client.WireMock.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.cloud.contract.spec.internal.HttpStatus
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit.jupiter.SpringExtension


class PostServiceTest @Autowired constructor(
    val postService: PostService,
    val postClient: PostClient
) : BaseSpringTest() {

    @BeforeEach
    fun init() {
        wireMockServer = WireMockServer()
        wireMockServer.start()
    }

    @AfterEach
    fun shutDown() {
        wireMockServer.stop()
    }

    @Test
    fun getPost() {
        stubFor(
            WireMock.get(WireMock.urlEqualTo("/posts/1"))
                .willReturn(
                    WireMock.aResponse()
                        .withStatus(HttpStatus.OK)
                        .withHeader("Content-Type", "application/json")
                        .withBody(getBody)
                )
        )

        assertThat(postService.getPost(1).title).isEqualTo("delectus aut autem")
        verify(getRequestedFor(urlEqualTo("/posts/1")))
    }

    @Test
    fun getComments() {
        stubFor(
            WireMock.get(WireMock.urlEqualTo("/comments?postId=1"))
                .willReturn(
                    WireMock.aResponse()
                        .withStatus(HttpStatus.OK)
                        .withHeader("Content-Type", "application/json")
                        .withBody(commentBody)
                )
        )

        assertThat(postService.getComments(1).size).isEqualTo(1)
    }

    @Test
    fun createPost() {
        stubFor(WireMock.post(WireMock.urlEqualTo("/posts"))
                .withRequestBody(
                    equalToJson("{ \"userId\" : 1, \"title\" : \"THEO\", \"body\" : \"GAMEHUB\"}")
                )
                .willReturn(
                    WireMock.aResponse()
                        .withStatus(HttpStatus.OK)
                        .withHeader("Content-Type", "application/json")
                        .withBody(postBody)
                )
        )

        assertThat(postService.createPost(todoRequest).title).isEqualTo("THEO")
    }
}

