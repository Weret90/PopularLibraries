package vboyko.gb.libs.lesson1.data

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import vboyko.gb.libs.lesson1.domain.User
import vboyko.gb.libs.lesson1.domain.UsersRepository
import java.lang.RuntimeException

object UsersRepositoryImpl : UsersRepository {

    private val usersList = mutableListOf<User>()

    init {
        for (i in 1..100) {
            usersList.add(User(i, "Name_$i", "Lastname_$i", "Login_$i"))
        }
    }

    override fun getUsersList(): Single<List<User>> = Single.create { emitter ->
        Thread.sleep(3000) //время имитации работы с сервером
        emitter.onSuccess(usersList)
    }

    override fun getUserLogin(userId: Int): Single<String> = Single.create { emitter ->
        Thread.sleep(2000) //время имитации работы с сервером
        emitter.onSuccess(getUserById(userId).login)
    }

    override fun getUserById(userId: Int): User {
        usersList.forEach { user ->
            if (user.id == userId) return user
        }
        throw RuntimeException("User with id $userId not found")
    }
}