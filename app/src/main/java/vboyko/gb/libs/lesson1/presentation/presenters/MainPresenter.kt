package vboyko.gb.libs.lesson1.presentation.presenters

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import vboyko.gb.libs.lesson1.presentation.interfaces.MainView
import vboyko.gb.libs.lesson1.presentation.interfaces.Screens

class MainPresenter(private val router: Router, private val screen: Screens) : MvpPresenter<MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(screen.usersList())
    }

    fun backClicked() {
        router.exit()
    }
}