package com.nikhil.bmicalculator

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun ButtonSection(
    onCalculateClick: () -> Unit,
    onClearClick: () -> Unit
){
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Box(modifier = Modifier
            .height(50.dp)
            .width(120.dp)
            .clickable { onCalculateClick() }
            .background(Color.Black, shape = RoundedCornerShape(30)),
            contentAlignment = Alignment.Center
        ) {
            Row {
                Text(
                    "Calculate",
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
                Icon(imageVector = Icons.Default.PlayArrow,
                    contentDescription = "Calculate",
                    tint = Color.White
                )
            }
        }

        Spacer(Modifier.width(10.dp))

        Box(modifier = Modifier
            .height(50.dp)
            .width(80.dp)
            .clickable {onClearClick()}
            .background(Color.Black, shape = RoundedCornerShape(30)),
            contentAlignment = Alignment.Center
        ) {
            Text(
                "Clear",
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
        }

    }
}