package vboyko.gb.libs.lesson1.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import vboyko.gb.libs.lesson1.data.model.UserDTO
import vboyko.gb.libs.lesson1.data.model.UserRepoDTO

@Database(entities = [UserDTO::class, UserRepoDTO::class], version = 2, exportSchema = false)
abstract class UsersDatabase : RoomDatabase() {

    companion object {
        private const val DB_NAME = "users.db"
        private var database: UsersDatabase? = null
        private val MONITOR = Any()

        fun getInstance(context: Context): UsersDatabase {
            synchronized(MONITOR) {
                if (database == null) {
                    database =
                        Room.databaseBuilder(context, UsersDatabase::class.java, DB_NAME)
                            .fallbackToDestructiveMigration()
                            .build()
                }
                return database!!
            }
        }
    }

    abstract fun usersDao(): UsersDao

    abstract fun reposDao(): ReposDao
}