package com.nikhil.bmicalculator

sealed class CalculateAction {
    object Clear:CalculateAction()
    object Calculate:CalculateAction()
}
