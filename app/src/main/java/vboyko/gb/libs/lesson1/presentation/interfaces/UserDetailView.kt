package vboyko.gb.libs.lesson1.presentation.interfaces

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle
import vboyko.gb.libs.lesson1.domain.entity.UserRepo

@AddToEndSingle
interface UserDetailView : MvpView {

    fun showUserReposList(list: List<UserRepo>)

    fun hideProgressBar()

    fun showErrorToast(error: Throwable)
}