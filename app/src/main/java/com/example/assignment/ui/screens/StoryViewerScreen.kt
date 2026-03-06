package com.example.assignment.ui.screens

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import com.example.assignment.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun StoryViewerScreen(
    name: String,
    image: Int,
    navController: NavController
) {

    val progress = remember { Animatable(0f) }

    LaunchedEffect(Unit) {

        progress.animateTo(
            1f,
            animationSpec = tween(5000) // 10 seconds
        )

        navController.popBackStack()
    }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {

        Column {
            Text(
                text = name,
                color = Color.Black,
                fontSize = 20.sp,
                modifier = Modifier.padding(16.dp)
            )
            LinearProgressIndicator(
                progress = progress.value,
                color = Color.Red,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(4.dp)
            )
            Image(
                painter = painterResource(image),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )


        }
    }
}