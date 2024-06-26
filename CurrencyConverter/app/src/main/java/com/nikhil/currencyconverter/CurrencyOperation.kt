package com.nikhil.currencyconverter

sealed class CurrencyOperation(val symbol:String){
    object Multiply: CurrencyOperation("x")
    object Divide: CurrencyOperation("/")
    object Add: CurrencyOperation("+")
    object Subtract: CurrencyOperation("-")
}