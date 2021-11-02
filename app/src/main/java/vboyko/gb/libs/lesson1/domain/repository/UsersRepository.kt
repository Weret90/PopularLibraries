package vboyko.gb.libs.lesson1.domain.repository

import io.reactivex.rxjava3.core.Single
import vboyko.gb.libs.lesson1.domain.entity.User
import vboyko.gb.libs.lesson1.domain.entity.UserRepo

interface UsersRepository {

    fun getUsersList(): Single<List<User>>

    fun getUserByLogin(userLogin: String): Single<User>

    fun getUserReposList(url: String): Single<List<UserRepo>>
}