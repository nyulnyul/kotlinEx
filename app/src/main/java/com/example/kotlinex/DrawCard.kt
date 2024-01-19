package com.example.kotlinex

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import com.example.kotlinex.Screen.CardBack
import com.example.kotlinex.Screen.CardFront

@Composable
fun DrawCard() {
    var cardFront by remember { mutableStateOf(true) }
    val anime by animateFloatAsState(targetValue = if (cardFront) 0f else 180f)
    var originPlayer by remember { mutableStateOf("Son") }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 50.dp, bottom = 50.dp, start = 20.dp, end = 20.dp)
            .clickable {
                cardFront = !cardFront
            }
            .graphicsLayer {
                rotationY = anime
            }
            .background(Color.White)) {
        if (anime <= 90) {
            CardFront(originPlayer = originPlayer, onPlayerChange = { originPlayer = it })
        } else {
            CardBack(originPlayer = originPlayer)

        }
    }
}