package com.example.assignment

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.assignment.ui.components.BottomNavBar
import com.example.assignment.ui.screens.HomeScreen
import com.example.assignment.ui.screens.ProfileScreen
import com.example.assignment.ui.screens.ReelsScreen
import com.example.assignment.ui.screens.SearchScreen
import com.example.assignment.ui.screens.StoryViewerScreen
import kotlinx.coroutines.launch

@Composable
fun MainScreen() {

    val navController = rememberNavController()

    val listState = rememberLazyListState()
    val scope = rememberCoroutineScope()

    Scaffold(
        bottomBar = {
            BottomNavBar(
                navController = navController,
                onHomeClick = {
                    scope.launch {
                        listState.animateScrollToItem(0)
                    }
                }
            )
        }
    ) { padding ->
        NavHost(
            navController = navController,
            startDestination = "home",
            modifier = Modifier.padding(padding)
        ) {

            composable("home") {
                HomeScreen(navController, listState)
            }

            composable("search") { SearchScreen() }

            composable("reels") { ReelsScreen() }

            composable("profile") { ProfileScreen() }

            composable(
                route = "story/{index}",
                arguments = listOf(
                    navArgument("index"){type= NavType.IntType}
                )
            ) { backStackEntry ->

                val index=backStackEntry.arguments?.getInt("index")?:0

                StoryViewerScreen(
                   startIndex = index,
                    navController = navController
                )
            }
        }
    }
}