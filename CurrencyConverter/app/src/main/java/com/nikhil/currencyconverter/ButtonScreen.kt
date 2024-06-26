package com.nikhil.currencyconverter

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nikhil.currencyconverter.ui.theme.CurrencyConverterTheme
import com.nikhil.currencyconverter.ui.theme.red
import com.nikhil.currencyconverter.ui.theme.yellow

@Composable
fun ButtonScreen(
    state: CurrencyData,
    modifier: Modifier = Modifier,
    onAction: (CurrencyAction) -> Unit,
    buttonSpacing: Dp = 20.dp
) {
    Column(
        modifier = modifier
            .fillMaxSize().padding(bottom = 5.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(20.dp))

        // Display the input and result
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 42.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            ConvertButton(symbol = "CON", onClick = { onAction(CurrencyAction.Convert) })

            Spacer(modifier = Modifier.width(34.dp))

            Box(
                modifier = Modifier
                    .height(60.dp)
                    .width(175.dp)
                    .background(yellow, RoundedCornerShape(20))
                    .border(1.dp, red, RoundedCornerShape(20))
                    ,

                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "RS " + state.number1 + state.number2,
                    fontSize = 20.sp,
                    fontFamily = FontFamily.Monospace,
                    color = red,
                )
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Buttons
        val buttons = listOf(
            listOf("1", "2", "3"),
            listOf("4", "5", "6"),
            listOf("7", "8", "9"),
            listOf(".", "0", "CLR")
        )

        buttons.forEach { row ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                row.forEach { symbol ->
                    Buttons(symbol = symbol, onClick = {
                        when (symbol) {
                            "1", "2", "3", "4", "5", "6", "7", "8", "9", "0" -> onAction(CurrencyAction.Number(symbol.toInt()))
                            "." -> onAction(CurrencyAction.Decimal)
                            "CLR" -> onAction(CurrencyAction.Clear)
                            "X" -> onAction(CurrencyAction.Convert)
                        }
                    })
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ButtonScreenPreview() {
    CurrencyConverterTheme {
        ButtonScreen(state = CurrencyData(), onAction = {})
    }
}
