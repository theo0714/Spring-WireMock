package com.example.wiremock.data

data class Post(
    val userId: Long,
    val id: Long,
    val title: String,
    val completed: Boolean
)