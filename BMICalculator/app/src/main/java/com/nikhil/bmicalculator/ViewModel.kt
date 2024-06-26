package com.nikhil.bmicalculator

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class BmiViewModel : ViewModel() {

    var state by mutableStateOf(BmiData())
        private set


    private val _weight = MutableStateFlow("")
    val weight: StateFlow<String> = _weight.asStateFlow()


    private val _height = MutableStateFlow("")
    val height: StateFlow<String> = _height.asStateFlow()

//    Functions

    fun onWeightChanged(newWeight: String) {
        _weight.value = newWeight
        calculate()
    }

    fun onHeightChanged(newHeight: String) {
        _height.value = newHeight
        calculate()
    }

    fun onAction(action: CalculateAction) {
        when (action) {
            is CalculateAction.Calculate -> calculate()
            is CalculateAction.Clear -> resetValue()
        }
    }

    private fun resetValue() {
        state = BmiData()
        Log.d("BmiViewModel", "Values reset: $state")
    }

    private fun calculate() {

        try {

            val height = _height.value.toDoubleOrNull()?.times(0.01)
            val weight = _weight.value.toDoubleOrNull()

            if (height != null && weight != null && height > 0) {
                val bmi = weight / (height * height)
                val limitedBmi = String.format("%.2f",bmi)

                state = state.copy(
                    result = limitedBmi
                )

                Log.d("BmiViewModel", "BMI calculated: $bmi")

            }
            else {

                state = state.copy(
                    result = "Invalid input"
                )

                Log.d("BmiViewModel", "Invalid input: height=$height, weight=$weight")

            }
        }
        catch (e: Exception) {

            Log.e("BmiViewModel", "Error in calculation: ${e.message}")

            state = state.copy(
                result = "Error : ${e.message}"
            )

        }
    }
}

