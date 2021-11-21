package vboyko.gb.libs.lesson1.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import vboyko.gb.libs.lesson1.data.database.ReposDao
import vboyko.gb.libs.lesson1.data.database.UsersDatabase
import vboyko.gb.libs.lesson1.data.repository.ReposRepositoryImpl
import vboyko.gb.libs.lesson1.domain.repository.ReposRepository
import javax.inject.Scope
import javax.inject.Singleton

@Module
interface ReposModule {

    @Binds
    @ReposScope
    fun bindReposRepository(impl: ReposRepositoryImpl): ReposRepository
}

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class ReposScope