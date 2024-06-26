package com.nikhil.currencyconverter

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nikhil.currencyconverter.ui.theme.gold
import com.nikhil.currencyconverter.ui.theme.green
import com.nikhil.currencyconverter.ui.theme.red
import com.nikhil.currencyconverter.ui.theme.yellow

@Composable
fun Buttons(
    modifier: Modifier = Modifier,
    symbol: String,
    onClick: () -> Unit
){
    Box(
        modifier = Modifier
            .height(50.dp)
            .width(70.dp)
            .shadow(10.dp, RoundedCornerShape(50))
            .clickable { onClick() }
            .background(red,RoundedCornerShape(30))
            .then(modifier),
        contentAlignment = Alignment.Center
    ){
        Text(
            symbol,
            style = TextStyle(
                color = Color.White,
                fontWeight = FontWeight.W500,
                fontSize = 20.sp,
                fontFamily = FontFamily.Monospace
            )
        )
    }
}

@Composable
fun ConvertButton(
    modifier: Modifier = Modifier,
    symbol: String,
    onClick: () -> Unit
){
    Box(
        modifier = Modifier
            .height(50.dp)
            .width(70.dp)
            .clickable { onClick() }
            .background(yellow,RoundedCornerShape(30))
            .border(1.dp, red, shape = RoundedCornerShape(30))
            .then(modifier),
        contentAlignment = Alignment.Center
    ){
        Text(
            symbol,
            style = TextStyle(
                color = red,
                fontWeight = FontWeight.W600,
                fontSize = 20.sp,
                fontFamily = FontFamily.Monospace
            )
        )
    }
}