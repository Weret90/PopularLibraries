package vboyko.gb.libs.lesson1.di

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import dagger.Module
import dagger.Provides
import vboyko.gb.libs.lesson1.data.database.ReposDao
import vboyko.gb.libs.lesson1.data.database.UsersDao
import vboyko.gb.libs.lesson1.data.database.UsersDatabase
import vboyko.gb.libs.lesson1.data.model.UserDTO
import vboyko.gb.libs.lesson1.data.model.UserRepoDTO
import vboyko.gb.libs.lesson1.domain.entity.User
import javax.inject.Singleton

@Module
class RoomModule {

    @Provides
    @Singleton
    fun provideDatabase(context: Context): UsersDatabase {
        return Room.databaseBuilder(context, UsersDatabase::class.java, "users.db")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideUsersDao(usersDatabase: UsersDatabase): UsersDao {
        return usersDatabase.usersDao()
    }

    @Provides
    @Singleton
    fun provideReposDao(usersDatabase: UsersDatabase): ReposDao {
        return usersDatabase.reposDao()
    }
}