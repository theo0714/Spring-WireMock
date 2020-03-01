package com.example.wiremock.test.service

import com.example.wiremock.BaseSpringTest
import com.example.wiremock.controller.PostRequest
import com.example.wiremock.service.PostService
import com.github.tomakehurst.wiremock.WireMockServer
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit.jupiter.SpringExtension

class PostServiceTestWithStubJsonFile @Autowired constructor(
    val postService: PostService
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
        assertThat(postService.getPost(1).title).isEqualTo("delectus aut autem")
    }

    @Test
    fun getComments() {
        assertThat(postService.getComments(1).size).isEqualTo(1)
        assertThat(postService.getComments(1)[0].email).isEqualTo("Eliseo@gardner.biz")

    }

    @Test
    fun createPost() {
        assertThat(postService.createPost(todoRequest).body).isEqualTo("GAMEHUB")
    }
}