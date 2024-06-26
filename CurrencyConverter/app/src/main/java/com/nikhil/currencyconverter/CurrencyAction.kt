package com.nikhil.currencyconverter

sealed class CurrencyAction {
    data class Number(val number:Int): CurrencyAction()
    object Decimal: CurrencyAction()
    object Delete: CurrencyAction()
    object Clear: CurrencyAction()
    object Convert: CurrencyAction()
}