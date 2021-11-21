package vboyko.gb.libs.lesson1.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.rxjava3.core.Single
import vboyko.gb.libs.lesson1.data.model.UserDTO

@Dao
interface UsersDao {
    @Query("SELECT * FROM users")
    fun getAllUsers(): Single<List<UserDTO>>

    @Query("DELETE FROM users")
    fun deleteAllUsers()

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addUser(userDTO: UserDTO)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addUsersList(usersList: List<UserDTO>)
}