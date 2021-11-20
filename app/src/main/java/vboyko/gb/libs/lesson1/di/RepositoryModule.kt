package vboyko.gb.libs.lesson1.di

import dagger.Binds
import dagger.Module
import vboyko.gb.libs.lesson1.data.repository.UsersRepositoryImpl
import vboyko.gb.libs.lesson1.domain.repository.UsersRepository
import javax.inject.Singleton

@Module
interface RepositoryModule {

    @Binds
    @Singleton
    fun bindUsersRepository(impl: UsersRepositoryImpl): UsersRepository
}