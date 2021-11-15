package vboyko.gb.libs.lesson1.presentation.presenters

import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpPresenter
import vboyko.gb.libs.lesson1.domain.entity.UserRepo
import vboyko.gb.libs.lesson1.domain.interactor.GetReposByUserIdFromDatabaseInteractor
import vboyko.gb.libs.lesson1.domain.interactor.GetUserReposListInteractor
import vboyko.gb.libs.lesson1.domain.repository.UsersRepository
import vboyko.gb.libs.lesson1.presentation.interfaces.Screens
import vboyko.gb.libs.lesson1.presentation.interfaces.UserDetailView

class UserDetailPresenter(
    private val router: Router,
    private val screen: Screens,
    repository: UsersRepository,
) :
    MvpPresenter<UserDetailView>() {

    private val getUserReposListInteractor = GetUserReposListInteractor(repository)
    private val getReposByUserIdFromDatabaseInteractor =
        GetReposByUserIdFromDatabaseInteractor(repository)

    fun backPressed(): Boolean {
        router.exit()
        return true
    }

    fun navigateToUserRepoDetailFragment(userRepo: UserRepo) {
        router.navigateTo(screen.userRepoDetail(userRepo))
    }

    fun getUserReposList(url: String, userId: Int) {
        getUserReposListInteractor.execute(url, userId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { userReposList ->
                    viewState.showUserReposList(userReposList)
                    viewState.hideProgressBar()
                },
                { throwable ->
                    getReposByUserId(userId)
                    viewState.showErrorToast(throwable)
                    viewState.hideProgressBar()
                }
            )
    }

    private fun getReposByUserId(userId: Int) {
        getReposByUserIdFromDatabaseInteractor.execute(userId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { userReposList ->
                    viewState.showUserReposList(userReposList)
                    viewState.hideProgressBar()
                },
                { throwable ->
                    viewState.showErrorToast(throwable)
                    viewState.hideProgressBar()
                }
            )
    }
}