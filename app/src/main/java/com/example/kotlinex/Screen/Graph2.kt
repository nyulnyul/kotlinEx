package com.example.kotlinex.Screen

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kotlinex.ui.theme.KotlinExTheme

@Composable
fun Graph2() {
    var inputper = remember{ mutableStateOf("0")}


    Box(modifier = Modifier.padding(top=120.dp)){
        val floatVal = inputper.value.toFloatOrNull() ?: 0f

        GraphPie(floatVal)


    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 30.dp),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            TextField(value = inputper.value, onValueChange = {inputper.value = it},
                label = { Text(text = "퍼센트 입력") },
                modifier = Modifier.size(200.dp, 50.dp))

        }

    }
}

@Composable
fun GraphPie(inputPie : Float){

    val piesize2 = 75f

    val colorList = listOf(Color.Gray, Color.Magenta)

    PieChart(inputPie,piesize2,colorList)


}

@Composable
fun PieChart(piesize1 : Float,piesize2 : Float,colorList: List<Color>){
    val totalSize = piesize1 + piesize2
    val sweep1 = 360 * (piesize1/ totalSize)
    val sweep2 = 360 * (piesize2/ totalSize)

    BoxWithConstraints(
        modifier = Modifier.padding(20.dp)
    ) {
        val pieDetailSize = constraints.maxWidth.toFloat()

        Canvas(modifier = Modifier.size(pieDetailSize.dp)){


            drawArc(
                color = colorList[0],
                startAngle = 0f,
                sweepAngle = sweep1,
                useCenter = true,
                size = Size(pieDetailSize,pieDetailSize),
            )


            drawArc(
                color = colorList[1],
                startAngle = sweep1,
                sweepAngle = sweep2,
                useCenter = true,
                size = Size(pieDetailSize,pieDetailSize),
            )


        }
        Column(modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally){
            Text(text = "$sweep1 / $ $sweep2",fontSize = 30.sp)


        }

    }
}
