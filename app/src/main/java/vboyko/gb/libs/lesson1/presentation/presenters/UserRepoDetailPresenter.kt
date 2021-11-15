package vboyko.gb.libs.lesson1.presentation.presenters

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import vboyko.gb.libs.lesson1.presentation.interfaces.Screens
import vboyko.gb.libs.lesson1.presentation.interfaces.UserRepoDetail

class UserRepoDetailPresenter(private val router: Router, private val screen: Screens) :
    MvpPresenter<UserRepoDetail>() {

    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}