package vboyko.gb.libs.lesson1.data

import io.reactivex.rxjava3.core.Single
import vboyko.gb.libs.lesson1.data.network.GithubApiService
import vboyko.gb.libs.lesson1.domain.entity.UserRepo
import vboyko.gb.libs.lesson1.domain.repository.UsersRepository

class UsersRepositoryImpl(private val githubApi: GithubApiService) : UsersRepository {

    override fun getUsersList() = githubApi.loadUsers()

    override fun getUserByLogin(userLogin: String) = githubApi.loadUser(userLogin)

    override fun getUserReposList(url: String): Single<List<UserRepo>> =
        githubApi.loadUserRepos(url)
}