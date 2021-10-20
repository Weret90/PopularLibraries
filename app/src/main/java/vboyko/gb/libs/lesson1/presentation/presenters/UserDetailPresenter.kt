package vboyko.gb.libs.lesson1.presentation.presenters

import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.Screen
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
        router.replaceScreen(screen.usersList()) //вопрос: почему когда я пишу вместо этого это:
//      router.backTo(screen.usersList())  -  при нажатии back ничего не происходит?
//      правильнее же прописывать backTo чем Replace???
        return true
    }

    fun getUserLogin(userId: Int) {
        val login = getUserLoginInteractor.execute(userId)
        viewState.showLogin(login)
    }
}