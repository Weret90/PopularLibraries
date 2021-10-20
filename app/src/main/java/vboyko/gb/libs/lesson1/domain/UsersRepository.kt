package vboyko.gb.libs.lesson1.domain

import vboyko.gb.libs.lesson1.domain.User

interface UsersRepository {

    fun getUsersList(): List<User>

    fun getUserLogin(userId: Int): String

    fun getUserById(userId: Int): User
}