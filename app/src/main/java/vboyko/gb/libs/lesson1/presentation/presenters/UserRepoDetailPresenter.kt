package vboyko.gb.libs.lesson1.presentation.presenters

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import vboyko.gb.libs.lesson1.presentation.interfaces.Screens
import vboyko.gb.libs.lesson1.presentation.interfaces.UserRepoDetail

class UserRepoDetailPresenter(private val router: Router, private val screen: Screens) :
    MvpPresenter<UserRepoDetail>() {

    fun backPressed(): Boolean {
        router.backTo(null)
        //что мне здесь написать чтобы вернуться обратно к экрану с списком репозиториев?
        //если надо писать:
        //router.backTo(screen.userDetail(???))
        //то необходимо достать параметр и вписать вместо ???, а именно url адрес репозитория,
        // что будет весьма хлопотно прокинуть в презентер. Неужели нет опции просто тупо назад
        //по цепочке без тщательного прописывания url в параметрах, будто делаем newInstance?
        //Можете пожалуйста вписать код, который бы работал? Всю голову сломал
        return true
    }
}