package ru.netology.dto

data class Post(
        val id: Long,
        val author: String,
        val content: String,
        val published: String,
        var likedByMe: Boolean = false,
        var countLike: Int = 0,
        var countShare: Int = 0
)
