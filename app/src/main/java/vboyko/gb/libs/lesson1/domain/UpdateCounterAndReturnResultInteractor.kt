package vboyko.gb.libs.lesson1.domain

import vboyko.gb.libs.lesson1.presentation.ButtonNum

class UpdateCounterAndReturnResultInteractor(private val repository: CountersRepository) {

    operator fun invoke(buttonNum: ButtonNum): String =
        repository.updateCounterAndReturnResult(buttonNum)
}