package vboyko.gb.libs.lesson1.data.network

import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Url
import vboyko.gb.libs.lesson1.data.model.UserDTO
import vboyko.gb.libs.lesson1.data.model.UserRepoDTO
import vboyko.gb.libs.lesson1.domain.entity.User
import vboyko.gb.libs.lesson1.domain.entity.UserRepo

interface GithubApiService {
    @GET("users")
    fun loadUsers(): Single<List<UserDTO>>

    @GET("users/{login}")
    fun loadUser(@Path("login") login: String): Single<UserDTO>

    @GET
    fun loadUserRepos(@Url url: String): Single<List<UserRepoDTO>>
}