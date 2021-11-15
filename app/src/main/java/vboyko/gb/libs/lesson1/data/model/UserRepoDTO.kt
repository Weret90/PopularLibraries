package vboyko.gb.libs.lesson1.data.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "repos", foreignKeys = [ForeignKey(
    entity = UserDTO::class,
    parentColumns = ["id"],
    childColumns = ["userId"],
    onDelete = ForeignKey.CASCADE
)])
class UserRepoDTO(

    @SerializedName("created_at")
    val createdAt: String,

    @SerializedName("description")
    val description: String?,

    @SerializedName("forks_count")
    val forksCount: Int,

    @PrimaryKey
    @SerializedName("id")
    val id: Int,

    @SerializedName("language")
    val language: String?,

    @SerializedName("name")
    val name: String,

    @SerializedName("url")
    val url: String,

    var userId: Int = 0
)