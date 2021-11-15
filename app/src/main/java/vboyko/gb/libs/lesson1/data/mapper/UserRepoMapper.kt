package vboyko.gb.libs.lesson1.data.mapper

import vboyko.gb.libs.lesson1.data.model.UserRepoDTO
import vboyko.gb.libs.lesson1.domain.entity.UserRepo

fun UserRepoDTO.toBusiness() = UserRepo(
    this.createdAt,
    this.description,
    this.forksCount,
    this.id,
    this.language,
    this.name,
    this.url,
    this.userId
)

fun List<UserRepoDTO>.toBusiness() = this.map {
    it.toBusiness()
}