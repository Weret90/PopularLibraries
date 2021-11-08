package vboyko.gb.libs.lesson1.data.repository

import io.reactivex.rxjava3.core.Single
import vboyko.gb.libs.lesson1.data.database.ReposDao
import vboyko.gb.libs.lesson1.data.database.UsersDao
import vboyko.gb.libs.lesson1.data.mapper.toBusiness
import vboyko.gb.libs.lesson1.data.model.UserDTO
import vboyko.gb.libs.lesson1.data.model.UserRepoDTO
import vboyko.gb.libs.lesson1.data.network.GithubApiService
import vboyko.gb.libs.lesson1.domain.entity.User
import vboyko.gb.libs.lesson1.domain.entity.UserRepo
import vboyko.gb.libs.lesson1.domain.repository.UsersRepository

class UsersRepositoryImpl(
    private val githubApi: GithubApiService,
    private val usersDao: UsersDao,
    private val reposDao: ReposDao,
) : UsersRepository {

    override fun getUsersList(): Single<List<User>> {
        return githubApi.loadUsers()
            .doOnSuccess {
                refreshUsers(it)
            }
            .map {
                it.toBusiness()
            }
    }

    override fun getUserByLogin(userLogin: String): Single<User> {
        return githubApi.loadUser(userLogin).map {
            it.toBusiness()
        }
    }

    override fun getUserReposList(url: String, userId: Int): Single<List<UserRepo>> {
        return githubApi.loadUserRepos(url)
            .doOnSuccess {
                refreshRepos(it, userId)
            }
            .map {
                it.toBusiness()
            }
    }

    override fun getAllUsersFromDatabase(): Single<List<User>> {
        return usersDao.getAllUsers().map {
            it.toBusiness()
        }
    }

    override fun getReposByUserIdFromDatabase(userId: Int): Single<List<UserRepo>> {
        return reposDao.findReposByUserId(userId).map {
            it.toBusiness()
        }
    }

    private fun refreshUsers(users: List<UserDTO>) {
        usersDao.deleteAllUsers()
        usersDao.addUsersList(users)
    }

    private fun refreshRepos(repos: List<UserRepoDTO>, userId: Int) {
        reposDao.deleteReposByUserId(userId)
        repos.map {
            it.userId = userId
        }
        reposDao.addReposList(repos)
    }
}