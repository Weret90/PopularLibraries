package vboyko.gb.libs.lesson1.presentation.interfaces

import com.github.terrakok.cicerone.Screen
import vboyko.gb.libs.lesson1.domain.entity.UserRepo

interface Screens {

    fun usersList(): Screen
    fun userDetail(userReposUrl: String, userId: Int): Screen
    fun userRepoDetail(userRepo: UserRepo): Screen
}