package vboyko.gb.libs.lesson1.presentation

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle
import vboyko.gb.libs.lesson1.domain.User

@AddToEndSingle
interface UsersListView: MvpView {
    fun showUsersList(usersList: List<User>)
}