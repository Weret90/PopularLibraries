package vboyko.gb.libs.lesson1.di

import dagger.Binds
import dagger.Module
import vboyko.gb.libs.lesson1.data.repository.ReposRepositoryImpl
import vboyko.gb.libs.lesson1.data.repository.UsersRepositoryImpl
import vboyko.gb.libs.lesson1.domain.repository.ReposRepository
import vboyko.gb.libs.lesson1.domain.repository.UsersRepository
import javax.inject.Singleton

@Module
interface RepositoryModule {

    @Binds
    @Singleton
    fun bindUsersRepository(impl: UsersRepositoryImpl): UsersRepository

    @Binds
    @Singleton
    fun bindReposRepository(impl: ReposRepositoryImpl): ReposRepository
}