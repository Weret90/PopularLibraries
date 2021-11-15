package vboyko.gb.libs.lesson1.domain.interactor

import io.reactivex.rxjava3.core.Single
import vboyko.gb.libs.lesson1.domain.entity.User
import vboyko.gb.libs.lesson1.domain.repository.UsersRepository

class GetUsersFromDatabaseInteractor(private val repository: UsersRepository) {

    fun execute(): Single<List<User>> {
        return repository.getAllUsersFromDatabase()
    }
}