package com.example.assignment.ui.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.assignment.R
import com.example.assignment.ui.components.PostItem
import com.example.assignment.ui.components.StoryRow
import com.example.assignment.ui.screens.PostCarousel
@Composable
fun HomeScreen(
    navController: NavController,
    listState: LazyListState
) {

    LazyColumn(
        state = listState
    ) {

        item {
            StoryRow(navController)
        }

        item {
            PostCarousel()
        }

        items(5) {

            PostItem(
                R.drawable.img_7
            )
        }
    }
}