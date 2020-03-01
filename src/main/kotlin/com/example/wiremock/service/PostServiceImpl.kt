package com.example.wiremock.service

import com.example.wiremock.client.PostClient
import com.example.wiremock.controller.PostRequest
import com.example.wiremock.controller.PostResponse
import com.example.wiremock.data.Comment
import com.example.wiremock.data.Post
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class PostServiceImpl @Autowired constructor(
    val postClient: PostClient
) : PostService {
    override fun getPost(id: Long): Post {
        val response = postClient.get(id)

        println("getToDo RETURN : ${response.body!!}")

        return response.body!!
    }

    override fun getComments(postId: Long): Array<Comment> {
        val response = postClient.getComment(postId)

        println("getComments RETURN : ${response.body!!}")

        return response.body!!
    }

    override fun createPost(postRequest: PostRequest): PostResponse {
        val response = postClient.create(postRequest)

        println("createToDo RETURN : ${response.body!!}")

        return response.body!!
    }
}