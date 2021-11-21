package vboyko.gb.libs.lesson1.domain.repository

import io.reactivex.rxjava3.core.Single
import vboyko.gb.libs.lesson1.domain.entity.User

interface UsersRepository {

    fun getUsersList(): Single<List<User>>

    fun getUserByLogin(userLogin: String): Single<User>

    fun getAllUsersFromDatabase(): Single<List<User>>
}