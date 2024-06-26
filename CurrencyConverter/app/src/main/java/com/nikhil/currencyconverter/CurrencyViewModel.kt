package com.nikhil.currencyconverter

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlin.math.max

class CurrencyViewModel : ViewModel() {
    var state by mutableStateOf(CurrencyData())
        private set

    fun onAction(action: CurrencyAction) {
        when (action) {
            is CurrencyAction.Number -> enterNumber(action.number)
            is CurrencyAction.Delete -> performDelete()
            is CurrencyAction.Clear -> state = CurrencyData()
            is CurrencyAction.Decimal -> insertDecimal()
            is CurrencyAction.Convert -> performConvert()
        }
    }

    private fun enterNumber(number: Int) {
        if (state.number1.length >= max_length) {
            return
        }
        state = state.copy(
            number1 = state.number1 + number
        )
        return

        if (state.number2.length >= max_length) {
            return
        }
        state = state.copy(
            number2 = state.number2 + number
        )
    }

    private fun performConvert() {
        val number1 = state.number1.toDoubleOrNull()?:0.0
        val number2 = state.number2.toDoubleOrNull()?:0.0
        val total_number = (state.number1 + state.number2).toDoubleOrNull()?:0.0
        if(number1 != null && number2 != null){
            val curr1 = String.format("%.2f",total_number?.times(1.91))
            val curr2 = String.format("%.2f",total_number?.times(0.018))
            val curr3 = String.format("%.2f",total_number?.times(0.016))
            val curr4 = String.format("%.2f",total_number?.times(1))

            state = state.copy(
                currency1 = curr1,
                currency2 = curr2,
                currency3 = curr3,
                currency4 = curr4
            )
        }
    }


    private fun performDelete() {
        when {
            state.number1.isNotBlank() -> state = state.copy(
                number1 = state.number1.dropLast(1)
            )

            state.number2.isNotBlank() -> state = state.copy(
                number2 = state.number2.dropLast(1)
            )
        }
    }


    private fun insertDecimal() {
        if (!state.number1.contains(".") && state.number1.isNotBlank()) {
            state = state.copy(
                number1 = state.number1 + "."
            )
            return
        }

        if (!state.number2.contains(".") && state.number2.isNotBlank()) {
            state = state.copy(
                number2 = state.number2 + "."
            )
        }

    }



    companion object {
        private const val max_length = 8
    }

}