package com.example.wiremock.controller

import com.example.wiremock.service.PostService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class ToDoController @Autowired constructor(
    val postService: PostService
){
    @GetMapping("/post/{id}")
    fun getPost(@PathVariable id: Long) = postService.getPost(id)

    @GetMapping("/comments")
    fun getComments(@RequestParam postId: Long)= postService.getComments(postId)

    @PostMapping("/post")
    fun createPost(@RequestBody request: PostRequest): PostResponse = postService.createPost(request)
}

data class PostRequest(
    val userId: Long,
    val title: String,
    val body: String
)

data class PostResponse(
    val id: Long,
    val userId: Long,
    val title: String,
    val body: String
)