package com.example.assignment.ui.components

import com.example.assignment.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.assignment.data.Story
import com.example.assignment.data.stories


@Composable
fun StoryRow(navController: NavController) {



    LazyRow(
        modifier = Modifier.padding(10.dp)
    ) {

        items(stories.size) { index ->

            val story = stories[index]

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(8.dp)
                    .clickable {
                        navController.navigate(
                            "story/${index}"
                        )
                    }
            ) {
                Image(
                    painter = painterResource(story.image),
                    contentDescription = null,
                    modifier = Modifier
                        .size(70.dp)
                        .clip(CircleShape)
                        .border(2.dp, Color.Red, CircleShape)
                )

                Text(story.name)
            }
        }
    }
}