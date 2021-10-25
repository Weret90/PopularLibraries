package vboyko.gb.libs.lesson1.presentation.presenters

import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpPresenter
import vboyko.gb.libs.lesson1.data.UsersRepositoryImpl
import vboyko.gb.libs.lesson1.domain.GetUserLoginInteractor
import vboyko.gb.libs.lesson1.presentation.interfaces.Screens
import vboyko.gb.libs.lesson1.presentation.interfaces.UserDetailView

class UserDetailPresenter(private val router: Router, private val screen: Screens) :
    MvpPresenter<UserDetailView>() {

    private val repository = UsersRepositoryImpl
    private val getUserLoginInteractor = GetUserLoginInteractor(repository)

    fun backPressed(): Boolean {
        router.replaceScreen(screen.usersList())
        return true
    }

    fun getUserLogin(userId: Int) {
        val loginObservable = getUserLoginInteractor.execute(userId)
        loginObservable
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { login ->
                    viewState.showLogin(login)
                    viewState.hideProgressBar()
                },
                { throwable ->
                    viewState.showErrorToast(throwable)
                    viewState.hideProgressBar()
                }
            )
    }
}