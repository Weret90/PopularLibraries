package vboyko.gb.libs.lesson1.domain.repository

import io.reactivex.rxjava3.core.Single
import vboyko.gb.libs.lesson1.domain.entity.UserRepo

interface ReposRepository {

    fun getUserReposList(url: String, userId: Int): Single<List<UserRepo>>

    fun getReposByUserIdFromDatabase(userId: Int): Single<List<UserRepo>>
}