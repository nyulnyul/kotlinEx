package com.example.kotlinex.Screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kotlinex.ui.theme.KotlinExTheme

@Composable
fun Graph3() {
    GraphBar()
}

@Composable
fun GraphBar() {
    val varDataList = listOf(10, 9, 21, 54, 21, 64, 32)
    BarChart(varDataList)

}

@Composable
fun BarChart(varDataList: List<Int>) {
    val maxDataValue = varDataList.max()
    Box(modifier = Modifier.fillMaxWidth().padding(top=150.dp)){
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            varDataList.forEach {
                Bar(it, maxDataValue!!)
            }
        }
    }


}

@Composable
fun Bar(barData: Int, maxDataValue: Int) {
    val heights = (barData.toFloat() / maxDataValue.toFloat()) * 300

    Box(modifier = Modifier
        .height(heights.dp)
        .width(30.dp)
        .background(Color.Cyan)) {
        Text(text = barData.toString())
    }
}