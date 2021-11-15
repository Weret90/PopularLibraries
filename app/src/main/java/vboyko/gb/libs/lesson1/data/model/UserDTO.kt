package vboyko.gb.libs.lesson1.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "users")
data class UserDTO (

    @SerializedName("avatar_url")
    val avatarUrl: String,

    @PrimaryKey
    @SerializedName("id")
    val id: Int,

    @SerializedName("login")
    val login: String,

    @SerializedName("repos_url")
    val reposUrl: String,
)