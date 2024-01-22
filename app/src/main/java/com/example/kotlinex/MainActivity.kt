package com.example.kotlinex

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.kotlinex.ui.theme.KotlinExTheme
import com.example.kotlinex.uiex.DrawCard

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DrawCard()


        }
    }
}

@Composable
fun ThemeTest1(){
    KotlinExTheme {
        Surface(modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background) {
            Text(text = "Hello World!",style = MaterialTheme.typography.titleLarge)
            Text(text = "Hello World!",style = MaterialTheme.typography.titleMedium)
        }
    }
}


@Preview(showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    name = "Light Mode")

@Composable
fun TestPreview() {
    KotlinExTheme {

    }
}
@Preview(showBackground = true,uiMode = Configuration.UI_MODE_NIGHT_YES,
    name = "Dark Mode")
@Composable
fun TestPreview2() {
    KotlinExTheme {

    }
}