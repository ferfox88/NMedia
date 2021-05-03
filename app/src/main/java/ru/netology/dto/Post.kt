package ru.netology.dto

data class Post(
        val id: Long,
        val author: String,
        val content: String,
        val published: String,
        val likedByMe: Boolean = false,
        val countLike: Int = 0,
        val countShare: Int = 0
)
