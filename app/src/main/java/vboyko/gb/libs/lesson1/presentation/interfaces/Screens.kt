package vboyko.gb.libs.lesson1.presentation.interfaces

import com.github.terrakok.cicerone.Screen

interface Screens {

    fun usersList(): Screen
    fun userDetail(userId: Int): Screen
}