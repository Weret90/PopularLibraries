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
import javax.inject.Inject

class UsersRepositoryImpl @Inject constructor(
    private val githubApi: GithubApiService,
    private val usersDao: UsersDao
) : UsersRepository {

    override fun getUsersList(): Single<List<User>> {
        return githubApi.loadUsers()
            .doOnSuccess {
                addUsersInDB(it)
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

    override fun getAllUsersFromDatabase(): Single<List<User>> {
        return usersDao.getAllUsers().map {
            it.toBusiness()
        }
    }

    private fun addUsersInDB(users: List<UserDTO>) {
        usersDao.addUsersList(users)
    }


}