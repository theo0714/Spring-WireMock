package com.example.wiremock.service

import com.example.wiremock.controller.PostRequest
import com.example.wiremock.controller.PostResponse
import com.example.wiremock.data.Comment
import com.example.wiremock.data.Post

interface PostService {
    fun getPost(id: Long): Post
    fun getComments(postId: Long): Array<Comment>
    fun createPost(postRequest: PostRequest): PostResponse
}