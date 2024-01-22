package com.example.kotlinex.uiex

import androidx.compose.ui.graphics.vector.ImageVector

data class NavigationItem(
    val name : String,
    val icon : ImageVector,
    val route : String
) {
}