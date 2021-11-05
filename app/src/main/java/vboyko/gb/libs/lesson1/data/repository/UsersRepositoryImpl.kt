package vboyko.gb.libs.lesson1.data.repository

import io.reactivex.rxjava3.core.Single
import vboyko.gb.libs.lesson1.data.mapper.toBusiness
import vboyko.gb.libs.lesson1.data.network.GithubApiService
import vboyko.gb.libs.lesson1.domain.entity.User
import vboyko.gb.libs.lesson1.domain.entity.UserRepo
import vboyko.gb.libs.lesson1.domain.repository.UsersRepository

class UsersRepositoryImpl(private val githubApi: GithubApiService) : UsersRepository {

    override fun getUsersList(): Single<List<User>> {
        return githubApi.loadUsers().map {
            it.toBusiness()
        }
    }

    override fun getUserByLogin(userLogin: String): Single<User> {
        return githubApi.loadUser(userLogin).map {
            it.toBusiness()
        }
    }

    override fun getUserReposList(url: String): Single<List<UserRepo>> {
        return githubApi.loadUserRepos(url).map {
            it.toBusiness()
        }
    }
}