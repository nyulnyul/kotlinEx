package com.example.kotlinex.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.kotlinex.DrawCard
import com.example.kotlinex.R

@Composable
fun CardFront(originPlayer: String, onPlayerChange: (String) -> Unit) {
    var player by remember { mutableStateOf("") }



    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xffffd700), shape = RoundedCornerShape(30.dp))
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
                .background(Color(0xFF38003C), shape = RoundedCornerShape(30.dp)),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    when (originPlayer) {
                        "Son" -> painterResource(id = R.drawable.son)
                        "Salah" -> painterResource(id = R.drawable.salah)
                        "Haaland" -> painterResource(id = R.drawable.hall)
                        else -> painterResource(id = R.drawable.son)
                    },

                    contentDescription = "Son",
                    modifier = Modifier.size(300.dp)
                )
                Spacer(modifier = Modifier.padding(20.dp))
                Text(
                    text = originPlayer,
                    style = MaterialTheme.typography.titleLarge, color = Color.White
                )
                TextField(value = player, onValueChange = { player = it })
                Button(onClick = { onPlayerChange(player)

                }) {
                    Text(text = "선수 변경")

                }

            }


        }

    }
}