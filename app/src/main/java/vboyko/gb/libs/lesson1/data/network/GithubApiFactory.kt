package vboyko.gb.libs.lesson1.data.network

import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object GithubApiFactory {

    private const val BASE_URL = "https://api.github.com/"

    private val githubRetrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val githubApi: GithubApiService = githubRetrofit.create(GithubApiService::class.java)
}