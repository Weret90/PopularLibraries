package vboyko.gb.libs.lesson1.presentation

import com.github.terrakok.cicerone.Screen
import com.github.terrakok.cicerone.androidx.FragmentScreen
import vboyko.gb.libs.lesson1.domain.entity.UserRepo
import vboyko.gb.libs.lesson1.presentation.fragments.UserDetailFragment
import vboyko.gb.libs.lesson1.presentation.fragments.UserRepoDetailFragment
import vboyko.gb.libs.lesson1.presentation.fragments.UsersListFragment
import vboyko.gb.libs.lesson1.presentation.interfaces.Screens

class AndroidScreens : Screens {

    override fun usersList(): Screen {
        return FragmentScreen { UsersListFragment.newInstance() }
    }

    override fun userDetail(userReposUrl: String): Screen {
        return FragmentScreen { UserDetailFragment.newInstance(userReposUrl) }
    }

    override fun userRepoDetail(userRepo: UserRepo): Screen {
        return FragmentScreen { UserRepoDetailFragment.newInstance(userRepo) }
    }
}