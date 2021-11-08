package vboyko.gb.libs.lesson1.domain.entity

data class UserRepo(
    val createdAt: String,
    val description: String?,
    val forksCount: Int,
    val id: Int,
    val language: String?,
    val name: String,
    val url: String,
    val userId: Int
)