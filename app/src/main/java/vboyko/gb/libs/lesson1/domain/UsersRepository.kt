package vboyko.gb.libs.lesson1.domain

import io.reactivex.rxjava3.core.Single

interface UsersRepository {

    fun getUsersList(): Single<List<User>>

    fun getUserLogin(userId: Int): Single<String>

    fun getUserById(userId: Int): User
}