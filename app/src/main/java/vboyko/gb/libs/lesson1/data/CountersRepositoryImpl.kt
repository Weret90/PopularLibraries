package vboyko.gb.libs.lesson1.data

import vboyko.gb.libs.lesson1.domain.CountersRepository
import vboyko.gb.libs.lesson1.presentation.ButtonNum

object CountersRepositoryImpl : CountersRepository {

    private val counters = mutableListOf(0, 0, 0)

    override fun updateCounterAndReturnResult(buttonNum: ButtonNum): String {
        val result = when (buttonNum) {
            ButtonNum.FIRST -> ++counters[0]
            ButtonNum.SECOND -> ++counters[1]
            ButtonNum.THIRD -> ++counters[2]
        }
        return result.toString()
    }
}