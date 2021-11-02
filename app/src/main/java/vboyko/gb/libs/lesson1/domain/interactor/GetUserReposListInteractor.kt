package vboyko.gb.libs.lesson1.domain.interactor

import io.reactivex.rxjava3.core.Single
import vboyko.gb.libs.lesson1.domain.entity.UserRepo
import vboyko.gb.libs.lesson1.domain.repository.UsersRepository

class GetUserReposListInteractor(private val repository: UsersRepository) {

    fun execute(url: String): Single<List<UserRepo>> {
        return repository.getUserReposList(url)
    }
}