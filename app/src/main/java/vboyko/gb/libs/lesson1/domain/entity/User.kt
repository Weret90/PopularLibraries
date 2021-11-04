package vboyko.gb.libs.lesson1.domain.entity


import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("avatar_url")
    val avatarUrl: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("login")
    val login: String,
    @SerializedName("repos_url")
    val reposUrl: String,
)
