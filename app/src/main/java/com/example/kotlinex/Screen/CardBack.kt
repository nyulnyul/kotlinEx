package com.example.kotlinex.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.kotlinex.R

@Composable
fun CardBack(originPlayer: String) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF04F5FF), shape = RoundedCornerShape(30.dp))
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
                .background(Color(0xFF38003C), shape = RoundedCornerShape(30.dp))
                .graphicsLayer { rotationY = 180f  },

            contentAlignment = Alignment.Center
        ) {
            when(originPlayer){
                "Son" -> Image(
                    painter = painterResource(id = R.drawable.tot),
                    contentDescription = "tottenham",
                    modifier = Modifier.size(300.dp)
                )
                "Salah" -> Image(
                    painter = painterResource(id = R.drawable.liv),
                    contentDescription = "liverpool",
                    modifier = Modifier.size(300.dp)
                )
                "Haaland" -> Image(
                    painter = painterResource(id = R.drawable.mc),
                    contentDescription = "mancity",
                    modifier = Modifier.size(300.dp)
                )
                else -> Image(
                    painter = painterResource(id = R.drawable.tot),
                    contentDescription = "tottenham",
                    modifier = Modifier.size(300.dp)
                )
            }



        }

    }
}