package vboyko.gb.libs.lesson1.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.rxjava3.core.Single
import vboyko.gb.libs.lesson1.data.model.UserRepoDTO

@Dao
interface ReposDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addRepo(repo: UserRepoDTO)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addReposList(repos: List<UserRepoDTO>)

    @Query("SELECT * FROM repos")
    fun getAllRepos(): List<UserRepoDTO>

    @Query("SELECT * FROM repos WHERE userId = :userId")
    fun findReposByUserId(userId: Int): Single<List<UserRepoDTO>>

    @Query("DELETE FROM repos WHERE userId = :userId")
    fun deleteReposByUserId(userId: Int)
}