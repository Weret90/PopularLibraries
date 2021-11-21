package vboyko.gb.libs.lesson1.presentation.presenters

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import vboyko.gb.libs.lesson1.presentation.interfaces.Screens
import vboyko.gb.libs.lesson1.presentation.interfaces.UserRepoDetail
import javax.inject.Inject

class UserRepoDetailPresenter @Inject constructor(
    private val router: Router,
    private val screen: Screens
    ) :
    MvpPresenter<UserRepoDetail>() {

    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}