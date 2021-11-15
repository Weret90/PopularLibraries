package vboyko.gb.libs.lesson1.presentation.mapper

import vboyko.gb.libs.lesson1.domain.entity.UserRepo
import vboyko.gb.libs.lesson1.presentation.model.UserRepoModel

fun UserRepo.toPresentationModel() = UserRepoModel(
    this.createdAt,
    this.description,
    this.forksCount,
    this.id,
    this.language,
    this.name,
    this.url,
    this.userId
)