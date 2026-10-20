package com.example.testapp1_2026

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.foundation.background
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun HelloScreen(){
    Column() {
        Text(
            text = " ",
            color = Color.White,
            modifier = Modifier
                .padding(16.dp)
                .background(Color.Black),
        )

        Button(onClick = {}) {
            Text("click")
        }

    }
}

@Preview
@Composable
fun ShowHelloScreen(){
    HelloScreen()
}

@Composable
fun Click(){
    var count by remember { mutableStateOf(0) }
    Button({count++}) {
        Text("$count раз")
    }

}
