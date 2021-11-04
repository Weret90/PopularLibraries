package vboyko.gb.libs.lesson1.domain.interactor

import io.reactivex.rxjava3.core.Single
import vboyko.gb.libs.lesson1.domain.repository.UsersRepository
import vboyko.gb.libs.lesson1.domain.entity.User

class GetUserByLoginInteractor(private val repository: UsersRepository) {

    fun execute(userLogin: String): Single<User> {
        return repository.getUserByLogin(userLogin)
    }
}