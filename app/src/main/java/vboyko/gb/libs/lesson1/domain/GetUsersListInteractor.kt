package vboyko.gb.libs.lesson1.domain

class GetUsersListInteractor(private val repository: UsersRepository) {

    fun execute(): List<User> {
        return repository.getUsersList()
    }
}