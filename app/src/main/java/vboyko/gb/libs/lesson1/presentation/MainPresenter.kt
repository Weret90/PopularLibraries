package vboyko.gb.libs.lesson1.presentation

import vboyko.gb.libs.lesson1.data.CountersRepositoryImpl
import vboyko.gb.libs.lesson1.domain.UpdateCounterAndReturnResultInteractor

class MainPresenter(private val view: MainView) {

    private val repository = CountersRepositoryImpl

    private val updateCounterAndReturnResultInteractor =
        UpdateCounterAndReturnResultInteractor(repository)

    private fun updateCounterAndReturnResult(buttonNum: ButtonNum): String =
        updateCounterAndReturnResultInteractor(buttonNum)


    fun updateCounterOnButton(buttonNum: ButtonNum) {
        val newValue = updateCounterAndReturnResult(buttonNum)
        view.setTextOnButton(buttonNum, newValue)
    }
}