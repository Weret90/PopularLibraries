package vboyko.gb.libs.lesson1.presentation.presenters

import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpPresenter
import vboyko.gb.libs.lesson1.domain.interactor.GetUsersFromDatabaseInteractor
import vboyko.gb.libs.lesson1.domain.interactor.GetUsersListInteractor
import vboyko.gb.libs.lesson1.domain.repository.UsersRepository
import vboyko.gb.libs.lesson1.presentation.interfaces.Screens
import vboyko.gb.libs.lesson1.presentation.interfaces.UsersListView

class UsersListPresenter(
    private val router: Router,
    private val screen: Screens,
    repository: UsersRepository,
) :
    MvpPresenter<UsersListView>() {

    private val getUsersListInteractor = GetUsersListInteractor(repository)
    private val getUsersFromDatabaseInteractor = GetUsersFromDatabaseInteractor(repository)

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        val usersListObservable = getUsersListInteractor.execute()
        usersListObservable
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { usersList ->
                    viewState.showUsersList(usersList)
                    viewState.hideProgressBar()
                },
                { throwable ->
                    viewState.showErrorToast(throwable)
                    viewState.hideProgressBar()
                    getUsersFromDB()
                }
            )
    }

    fun navigateToUserDetailFragment(userReposUrl: String, userId: Int) {
        router.navigateTo(screen.userDetail(userReposUrl, userId))
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }

    private fun getUsersFromDB() {
        getUsersFromDatabaseInteractor.execute()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { usersList ->
                    viewState.showUsersList(usersList)
                    viewState.hideProgressBar()
                },
                { throwable ->
                    viewState.showErrorToast(throwable)
                    viewState.hideProgressBar()
                }
            )
    }
}