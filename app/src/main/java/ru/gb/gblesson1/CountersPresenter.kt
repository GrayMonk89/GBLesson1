package ru.gb.gblesson1

import ru.gb.gblesson1.utils.DEFAULT_VALUE_ONE
import ru.gb.gblesson1.utils.DEFAULT_VALUE_TWO
import ru.gb.gblesson1.utils.DEFAULT_VALUE_ZERO

class CountersPresenter(
    private val view: MainView
) {
    private val model = CountersModel()

    fun onCounterClick(id: Int) {
        when (id) {
            DEFAULT_VALUE_ZERO -> {
                val newValue = model.next(0)
                view.setText(newValue.toString(), 0)
            }
            DEFAULT_VALUE_ONE -> {
                val newValue = model.next(1)
                view.setText(newValue.toString(), 1)
            }
            DEFAULT_VALUE_TWO -> {
                val newValue = model.next(2)
                view.setText(newValue.toString(), 2)
            }
        }
    }
}
