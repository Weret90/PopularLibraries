package vboyko.gb.libs.lesson1.data.mapper

import vboyko.gb.libs.lesson1.data.model.UserDTO
import vboyko.gb.libs.lesson1.domain.entity.User

fun UserDTO.toBusiness() = User(this.avatarUrl, this.id, this.login, this.reposUrl)

fun List<UserDTO>.toBusiness() = this.map {
    it.toBusiness()
}