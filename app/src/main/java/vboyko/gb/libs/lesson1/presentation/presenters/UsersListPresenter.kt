package vboyko.gb.libs.lesson1.presentation.presenters

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import vboyko.gb.libs.lesson1.data.UsersRepositoryImpl
import vboyko.gb.libs.lesson1.domain.GetUsersListInteractor
import vboyko.gb.libs.lesson1.presentation.interfaces.Screens
import vboyko.gb.libs.lesson1.presentation.interfaces.UsersListView

class UsersListPresenter(private val router: Router, private val screen: Screens) : MvpPresenter<UsersListView>() {

    private val repository = UsersRepositoryImpl

    private val getUsersListInteractor = GetUsersListInteractor(repository)

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        val usersList = getUsersListInteractor.execute()
        viewState.showUsersList(usersList)
    }

    fun navigateToUserDetailFragment(userId: Int) {
        router.replaceScreen(screen.userDetail(userId))
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}