package vboyko.gb.libs.lesson1.data.repository

import io.reactivex.rxjava3.core.Single
import vboyko.gb.libs.lesson1.data.database.ReposDao
import vboyko.gb.libs.lesson1.data.mapper.toBusiness
import vboyko.gb.libs.lesson1.data.model.UserRepoDTO
import vboyko.gb.libs.lesson1.data.network.GithubApiService
import vboyko.gb.libs.lesson1.domain.entity.UserRepo
import vboyko.gb.libs.lesson1.domain.repository.ReposRepository
import javax.inject.Inject

class ReposRepositoryImpl @Inject constructor(
    private val githubApi: GithubApiService,
    private val reposDao: ReposDao
): ReposRepository {

    override fun getUserReposList(url: String, userId: Int): Single<List<UserRepo>> {
        return githubApi.loadUserRepos(url)
            .doOnSuccess {
                addReposInDB(it, userId)
            }
            .map {
                it.toBusiness()
            }
    }

    override fun getReposByUserIdFromDatabase(userId: Int): Single<List<UserRepo>> {
        return reposDao.findReposByUserId(userId).map {
            it.toBusiness()
        }
    }

    private fun addReposInDB(repos: List<UserRepoDTO>, userId: Int) {
        repos.map {
            it.userId = userId
        }
        reposDao.addReposList(repos)
    }
}