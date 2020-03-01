package com.example.wiremock.data

data class Comment(
    val postId: Long,
    val id: Long,
    val name: String,
    val email: String,
    val body: String
)