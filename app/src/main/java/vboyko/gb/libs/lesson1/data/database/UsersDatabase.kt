package vboyko.gb.libs.lesson1.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import vboyko.gb.libs.lesson1.data.model.UserDTO
import vboyko.gb.libs.lesson1.data.model.UserRepoDTO

@Database(entities = [UserDTO::class, UserRepoDTO::class], version = 2, exportSchema = false)
abstract class UsersDatabase : RoomDatabase() {

    abstract fun usersDao(): UsersDao

    abstract fun reposDao(): ReposDao
}