package vboyko.gb.libs.lesson1.domain

import io.reactivex.rxjava3.core.Single

class GetUserLoginInteractor(private val repository: UsersRepository) {

    fun execute(userId: Int): Single<String> {
        return repository.getUserLogin(userId)
    }
}