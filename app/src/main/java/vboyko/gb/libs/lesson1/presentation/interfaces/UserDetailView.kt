package vboyko.gb.libs.lesson1.presentation.interfaces

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
interface UserDetailView : MvpView {

    fun showLogin(userLogin: String)

    fun hideProgressBar()

    fun showErrorToast(error: Throwable)
}