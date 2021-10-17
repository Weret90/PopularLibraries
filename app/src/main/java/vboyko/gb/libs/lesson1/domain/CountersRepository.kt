package vboyko.gb.libs.lesson1.domain

import vboyko.gb.libs.lesson1.presentation.ButtonNum

interface CountersRepository {

    fun updateCounterAndReturnResult(buttonNum: ButtonNum): String
}