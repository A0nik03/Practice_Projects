package com.nikhil.bmicalculator

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nikhil.bmicalculator.ui.theme.BMICalculatorTheme

@Composable
fun BmiScreen(
    modifier: Modifier = Modifier,
    viewmodel: BmiViewModel,
    onAction: (CalculateAction) -> Unit
) {

    val weight by viewmodel.weight.collectAsState()
    val height by viewmodel.height.collectAsState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            "BMI CALCULATOR",
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 28.sp
            )
        )

        Spacer(Modifier.height(30.dp))

        Box(
            modifier = Modifier
                .height(300.dp)
                .width(350.dp)
                .background(color = Color.LightGray, shape = RoundedCornerShape(10))
                .padding(24.dp),
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        "Height: ",
                        style = TextStyle(
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp
                        )
                    )

                    OutlinedTextField(
                        modifier = Modifier.background(Color.White),
                        value = height,
                        placeholder = { Text("Cm") },
                        onValueChange = { newHeight ->
                            viewmodel.onHeightChanged(newHeight)
                        })
                }

                Spacer(modifier = Modifier.height(20.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        "Weight: ",
                        style = TextStyle(
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp
                        )
                    )

                    OutlinedTextField(
                        modifier = Modifier.background(Color.White),
                        value = weight,
                        placeholder = { Text("Kg") },
                        onValueChange = { newWeight ->
                            viewmodel.onWeightChanged(newWeight)
                        })
                }

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    "BMI: ${viewmodel.state.result}",
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(20.dp))

                ButtonSection(
                    onClearClick = { onAction(CalculateAction.Clear) },
                    onCalculateClick = { onAction(CalculateAction.Calculate) }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BmiPreview() {
    BMICalculatorTheme {
        BmiScreen(Modifier.fillMaxSize(), onAction = {}, viewmodel = BmiViewModel())
    }
}
