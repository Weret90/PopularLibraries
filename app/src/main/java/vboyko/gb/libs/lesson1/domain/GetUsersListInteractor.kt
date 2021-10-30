package vboyko.gb.libs.lesson1.domain

import io.reactivex.rxjava3.core.Single

class GetUsersListInteractor(private val repository: UsersRepository) {

    fun execute(): Single<List<User>> {
        return repository.getUsersList()
    }
}