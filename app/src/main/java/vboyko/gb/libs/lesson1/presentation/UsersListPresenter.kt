package vboyko.gb.libs.lesson1.presentation

import moxy.MvpPresenter
import vboyko.gb.libs.lesson1.data.UsersRepositoryImpl
import vboyko.gb.libs.lesson1.domain.GetUsersListInteractor

class UsersListPresenter : MvpPresenter<UsersListView>() {

    private val repository = UsersRepositoryImpl

    private val getUsersListInteractor = GetUsersListInteractor(repository)

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        val usersList = getUsersListInteractor.execute()
        viewState.showUsersList(usersList)
    }
}