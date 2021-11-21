package vboyko.gb.libs.lesson1.presentation.interfaces

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle
import vboyko.gb.libs.lesson1.domain.entity.User

@AddToEndSingle
interface UsersListView : MvpView {

    fun showUsersList(usersList: List<User>)

    fun showErrorToast(t: Throwable)

    fun hideProgressBar()

    fun releaseUserScope()
}