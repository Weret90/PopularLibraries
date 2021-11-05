package vboyko.gb.libs.lesson1.data.model

import com.google.gson.annotations.SerializedName

data class UserDTO (
    @SerializedName("avatar_url")
    val avatarUrl: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("login")
    val login: String,
    @SerializedName("repos_url")
    val reposUrl: String,
)