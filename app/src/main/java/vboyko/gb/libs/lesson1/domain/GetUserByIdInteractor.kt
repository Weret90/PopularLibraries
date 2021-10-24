package vboyko.gb.libs.lesson1.domain

class GetUserByIdInteractor(private val repository: UsersRepository) {

    fun execute(userId: Int): User {
        return repository.getUserById(userId)
    }
}