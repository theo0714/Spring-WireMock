package com.example.wiremock.client

import com.example.wiremock.controller.PostRequest
import com.example.wiremock.controller.PostResponse
import com.example.wiremock.data.Comment
import com.example.wiremock.data.Post
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate


@Component
class PostClient @Autowired constructor(
    val restTemplate: RestTemplate,
    @Value("\${todo.url}") val url: String
    ) {
    fun get(id: Long): ResponseEntity<Post> {
        println("Todo Client URL : $url/posts/$id")

        return restTemplate.getForEntity( "$url/posts/$id", Post::class.java)
    }

    fun getComment(postId: Long): ResponseEntity<Array<Comment>> {
        println("Todo Client URL : $url/comments?postId=$postId")

        return restTemplate.getForEntity("$url/comments?postId=$postId", Array<Comment>::class.java)
    }

    fun create(postRequest: PostRequest): ResponseEntity<PostResponse> {
        println("Todo Client URL : $url/posts")

        return restTemplate.postForEntity("$url/posts",postRequest, PostResponse::class.java)
    }
}