package vboyko.gb.libs.lesson1.presentation

import com.github.terrakok.cicerone.Screen
import com.github.terrakok.cicerone.androidx.FragmentScreen
import vboyko.gb.libs.lesson1.presentation.fragments.UserDetailFragment
import vboyko.gb.libs.lesson1.presentation.fragments.UsersListFragment
import vboyko.gb.libs.lesson1.presentation.interfaces.Screens

class AndroidScreens : Screens {

    override fun usersList(): Screen {
        return FragmentScreen { UsersListFragment.newInstance() }
    }

    override fun userDetail(userId: Int): Screen {
        return FragmentScreen { UserDetailFragment.newInstance(userId) }
    }
}