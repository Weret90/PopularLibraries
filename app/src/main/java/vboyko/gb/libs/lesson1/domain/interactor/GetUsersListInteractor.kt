package vboyko.gb.libs.lesson1.domain.interactor

import io.reactivex.rxjava3.core.Single
import vboyko.gb.libs.lesson1.domain.repository.UsersRepository
import vboyko.gb.libs.lesson1.domain.entity.User
import javax.inject.Inject

class GetUsersListInteractor @Inject constructor(private val repository: UsersRepository) {

    fun execute(): Single<List<User>> {
        return repository.getUsersList()
    }
}