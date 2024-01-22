package com.example.kotlinex.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.MailOutline
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material.icons.outlined.ThumbUp
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.kotlinex.R
import com.example.kotlinex.data.postList

import com.example.kotlinex.data.storyList

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Image(
                        modifier = Modifier
                            .width(140.dp)
                            .padding(top = 10.dp),
                        contentScale = ContentScale.FillWidth,
                        painter = painterResource(id = R.drawable.mc),
                        contentDescription = "mancity"
                    )
                },
                actions = {
                    Icon(
                        modifier = Modifier.width(30.dp),
                        imageVector = Icons.Filled.ThumbUp,
                        contentDescription = "like"
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Icon(
                        modifier = Modifier.width(30.dp),
                        imageVector = Icons.Filled.MailOutline,
                        contentDescription = "message"
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                })
        }, bottomBar = {
            Row(
                modifier = Modifier
                    .background(Color.White)
                    .border(1.dp, Color.Gray)
                    .fillMaxWidth()
                    .padding(top = 10.dp), horizontalArrangement = Arrangement.SpaceAround
            ) {
                Icon(
                    modifier = Modifier.size(30.dp),
                    imageVector = Icons.Outlined.Home,
                    contentDescription = "Home"
                )
                Icon(
                    modifier = Modifier.size(30.dp),
                    imageVector = Icons.Outlined.Search,
                    contentDescription = "Home"
                )
                Icon(
                    modifier = Modifier.size(30.dp),
                    imageVector = Icons.Outlined.Share,
                    contentDescription = "Home"
                )
                Icon(
                    modifier = Modifier.size(30.dp),
                    imageVector = Icons.Outlined.AccountCircle,
                    contentDescription = "Home"
                )

            }

        }
    ) {
        LazyColumn(modifier = Modifier.padding(it)) {
            item {
                LazyRow() {
                    items(storyList) {
                        Column(
                            Modifier.padding(10.dp, 9.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Image(
                                modifier = Modifier
                                    .size(64.dp)
                                    .clip(CircleShape)
                                    .border(1.dp, Color.Red, CircleShape)
                                    .padding(3.dp)
                                    .clip(
                                        CircleShape
                                    )
                                    .border(2.dp, Color.White, CircleShape),
                                painter = painterResource(id = it.profile),
                                contentDescription = null
                            )

                            Text(text = it.name, style = TextStyle(color = Color.Black))
                        }

                    }
                }

            }
            items(postList) {
                Column(Modifier.padding(top = 10.dp)) {
                    Row(
                        Modifier
                            .padding(10.dp)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ) {}
                        Image(
                            modifier = Modifier
                                .size(45.dp)
                                .padding(3.dp)
                                .clip(CircleShape)
                                .border(1.dp, Color.Red, CircleShape),
                            painter = painterResource(id = it.profile),
                            contentDescription = null
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(
                            text = it.name,
                            style = TextStyle(color = Color.Black, fontWeight = FontWeight.Medium)
                        )
                        Icon(
                            modifier = Modifier.width(15.dp),
                            imageVector = Icons.Outlined.Menu,
                            contentDescription = "menu"
                        )
                    }
                    Spacer(modifier = Modifier.height(5.dp))
                    Image(
                        modifier = Modifier.height(300.dp),
                        contentScale = ContentScale.FillWidth,
                        painter = painterResource(id = it.post),
                        contentDescription = null
                    )
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .padding(10.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row(){
                            Icon(
                                modifier = Modifier.width(25.dp),
                                imageVector = Icons.Outlined.ThumbUp,
                                contentDescription = "menu"
                            )
                            Spacer(modifier = Modifier.height(5.dp))
                            Icon(
                                modifier = Modifier.width(25.dp),
                                imageVector = Icons.Outlined.MailOutline,
                                contentDescription = "menu"
                            )
                            Spacer(modifier = Modifier.height(5.dp))

                            Icon(
                                modifier = Modifier.width(25.dp),
                                imageVector = Icons.Outlined.Share,
                                contentDescription = "menu"
                            )
                            Spacer(modifier = Modifier.height(5.dp))

                        }
                        Icon(
                            modifier = Modifier.width(25.dp),
                            imageVector = Icons.Outlined.Add,
                            contentDescription = "menu"
                        )
                        Spacer(modifier = Modifier.height(5.dp))

                    }
                    Column(Modifier.padding(10.dp)){
                        Text("100명이 좋아합니다.")
                        Text("#mancity 파이팅")
                    }


                }

            }
        }

    }
}