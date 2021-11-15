package vboyko.gb.libs.lesson1.presentation.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserRepoModel(
    val createdAt: String,
    val description: String?,
    val forksCount: Int,
    val id: Int,
    val language: String?,
    val name: String,
    val url: String,
    val userId: Int
) : Parcelable