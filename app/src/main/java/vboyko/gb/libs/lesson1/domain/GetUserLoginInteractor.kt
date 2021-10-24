package vboyko.gb.libs.lesson1.domain

class GetUserLoginInteractor(private val repository: UsersRepository) {

    fun execute(userId: Int): String {
        return repository.getUserLogin(userId)
    }
}