package com.example.assignment.ui.screens

import androidx.compose.animation.*
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.assignment.data.Story
import com.example.assignment.data.stories


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun StoryViewerScreen(
    startIndex: Int,
    navController: NavController
) {

    var currentIndex by remember { mutableStateOf(startIndex) }

    val progress = remember { Animatable(0f) }

    LaunchedEffect(currentIndex) {

        progress.snapTo(0f)

        progress.animateTo(
            1f,
            animationSpec = tween(10000)
        )

        if (currentIndex < stories.lastIndex) {
            currentIndex++
        } else {
            navController.popBackStack()
        }
    }

    Box(Modifier.fillMaxSize()) {

        Column {

            val story = stories[currentIndex]

            Text(
                text = story.name,
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

            AnimatedContent(
                targetState = currentIndex,
                transitionSpec = {
                    slideInHorizontally { width -> width } togetherWith
                            slideOutHorizontally { width -> -width }
                }
            ) { index ->

                val animatedStory = stories[index]

                Image(
                    painter = painterResource(animatedStory.image),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            }
        }
    }
}