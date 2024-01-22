package com.example.kotlinex.uiex

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

@Composable
fun GraphAppMain() {
    val navController = rememberNavController()
    val navItems = listOf(
        NavigationItem(
            name = "Graph1",
            icon = Icons.Filled.Home,
            route = "Graph1"
        ),
        NavigationItem(
            name = "Graph2",
            icon = Icons.Filled.Favorite,
            route = "Graph2"
        ),
        NavigationItem(
            name = "Graph3",
            icon = Icons.Filled.Settings,
            route = "Graph3"
        )
    )
    Scaffold(
        bottomBar = {
            BottomAppBar {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    navItems.forEach {
                        val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route
                        Column(
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.size(40.dp).clickable { navController.navigate(it.route) }

                        ) {
                            val isCurrentRoute = it.route == currentRoute
                            Icon(
                                imageVector = it.icon,
                                contentDescription = it.name,
                                tint = if(isCurrentRoute) Color.Cyan else Color.LightGray
                            )
                            Text(text = it.name, fontSize = 10.sp,
                                color =if(isCurrentRoute) Color.Blue else Color.LightGray)

                        }
                    }
                }
            }
        }
    ) {
        NavHost(
            navController = navController,
            startDestination = navItems.first().route,
            modifier = Modifier.padding(it),
        ) {
            composable("Graph1") {
                Graph1()
            }
            composable("Graph2") {
                Graph2()
            }
            composable("Graph3") {
                Graph3()
            }


        }
    }
}

