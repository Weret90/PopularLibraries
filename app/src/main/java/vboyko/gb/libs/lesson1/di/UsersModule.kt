package vboyko.gb.libs.lesson1.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import vboyko.gb.libs.lesson1.data.database.UsersDao
import vboyko.gb.libs.lesson1.data.database.UsersDatabase
import vboyko.gb.libs.lesson1.data.repository.ReposRepositoryImpl
import vboyko.gb.libs.lesson1.data.repository.UsersRepositoryImpl
import vboyko.gb.libs.lesson1.domain.repository.ReposRepository
import vboyko.gb.libs.lesson1.domain.repository.UsersRepository
import javax.inject.Scope
import javax.inject.Singleton

@Module
interface UsersModule {

    @Binds
    @UsersScope
    fun bindUsersRepository(impl: UsersRepositoryImpl): UsersRepository
}

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class UsersScope