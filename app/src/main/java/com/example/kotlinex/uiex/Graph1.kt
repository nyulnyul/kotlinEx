package com.example.kotlinex.uiex

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Graph1() {
    var inputper = remember{ mutableStateOf(0f)}
    var maxPer = 100f

    Box(modifier = Modifier.padding(top=120.dp)){
        GraphGauge(per = inputper.value, maxPer = maxPer)
    }

    Column(
        modifier = Modifier.fillMaxSize().padding(bottom = 20.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Row(modifier = Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.SpaceAround){
            Button(onClick = { if(inputper.value < maxPer) inputper.value += 10f}) {
                Text(text = "증가")
            }
            Button(onClick = {inputper.value = 0f}){
                Text(text = "초기화")
            }
        }

    }
}

@Composable
fun GraphGauge(per : Float , maxPer : Float){
    val colorPer = 360 * (per/ maxPer)

    Box(modifier = Modifier
        .fillMaxWidth()
        .aspectRatio(1f)
        .padding(20.dp)){

        Canvas(modifier = Modifier.fillMaxSize()){
            drawArc(
                color = Color.LightGray,
                startAngle = 0f,
                sweepAngle = 360f,
                useCenter = false,
                style = Stroke(32f)
            )
            drawArc(
                color = Color.Blue,
                startAngle = -90f,
                sweepAngle = colorPer,
                useCenter = false,
                style = Stroke(32f)
            )
        }
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(text = "${((per/maxPer)*100).toInt()}%",
                fontSize = 30.sp,)
            Text(text = "$per / $maxPer",
                fontSize = 30.sp,)
        }
    }
}
