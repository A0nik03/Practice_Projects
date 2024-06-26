package com.nikhil.currencyconverter

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.nikhil.currencyconverter.ui.theme.CurrencyConverterTheme
import com.nikhil.currencyconverter.ui.theme.gold
import com.nikhil.currencyconverter.ui.theme.red
import com.nikhil.currencyconverter.ui.theme.yellow

@SuppressLint("UnusedBoxWithConstraintsScope")
@Composable
fun CurrencyScreen(
    modifier: Modifier = Modifier,
    state: CurrencyData,
    onAction: (CurrencyAction) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        BoxWithConstraints{

            Box(
                modifier = Modifier
                    .aspectRatio(ratio = 0.9f)
                    .background(color = yellow)
                    .padding(20.dp),
                contentAlignment = Alignment.TopStart
            ) {

                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Spacer(modifier = Modifier.height(10.dp))
                    TopAppBarSection()
                    Spacer(modifier = Modifier.height(40.dp))

                    val JPN = stringResource(R.string.japan_flag)
                    CurrencyRow(amount = state.currency1, country = "JPN", url = JPN, symbol = "¥")
                    Spacer(modifier = Modifier.height(20.dp))

                    val AUS = stringResource(R.string.aus_flag)
                    CurrencyRow(amount = state.currency2, country = "AUS", url = AUS, symbol = "AU$")
                    Spacer(modifier = Modifier.height(20.dp))

                    val CND = stringResource(R.string.canada_flag)
                    CurrencyRow(amount = state.currency3, country = "CND", url = CND, symbol = "CA$")
                    Spacer(modifier = Modifier.height(20.dp))

                    val IND = stringResource(R.string.india_flag)
                    CurrencyRow(amount = state.currency4, country = "IND", url = IND, symbol = "RS")
                    Spacer(modifier = Modifier.height(12.dp))
                }

            }
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = gold)
        ) {
            ButtonScreen(state,modifier = modifier,onAction)
        }
    }
}


@Composable
fun CurrencyRow(
    country:String,
    symbol:String,
    amount:String,
    url: String
){
    Box(
        modifier = Modifier
            .height(40.dp)
            .width(350.dp)
            .shadow(20.dp)
            .background(gold, RoundedCornerShape(30))
            .padding(start = 10.dp, end = 10.dp),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(2.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier.padding(4.dp),
                contentAlignment = Alignment.Center
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Box(modifier = Modifier
                        .size(30.dp)
                        .clip(RoundedCornerShape(100))
                    ){
                        JpgImage(url = url)
                    }
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        country,
                        fontSize = 16.sp,
                        color = red,
                        fontFamily = FontFamily.Monospace,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            Text(" $symbol $amount",
                fontSize = 15.sp,
                fontFamily = FontFamily.Monospace,
                color = red)
        }
    }
}

@Composable
fun JpgImage(url: String) {
    val painter = rememberAsyncImagePainter(model = url)
    Image(
        painter = painter,
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .fillMaxSize()
            .size(1000.dp),

        )
}


@Composable
fun TopAppBarSection(){
    Box(
        modifier = Modifier
            .height(60.dp)
            .padding(start = 15.dp),
        contentAlignment = Alignment.TopStart
    ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Box(
                    modifier = Modifier
                        .width(60.dp)
                        .height(60.dp)
                        .background(red, RoundedCornerShape(30)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowLeft,
                        contentDescription = "LeftArrow",
                        modifier = Modifier.size(30.dp),
                        tint = gold
                    )
                }

                Box(
                    modifier = Modifier
                        .padding(end = 12.dp)
                        .width(60.dp)
                        .height(60.dp)
                        .background(red, RoundedCornerShape(30)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.Notifications,
                        contentDescription = "Bell",
                        modifier = Modifier.size(30.dp),
                        tint = gold
                    )
                }
            }
        }
}


@Preview(showBackground = true)
@Composable
fun CurrencyPreview() {
    CurrencyConverterTheme {
        CurrencyScreen(state = CurrencyData(), modifier = Modifier.fillMaxSize(), onAction = {})
    }
}