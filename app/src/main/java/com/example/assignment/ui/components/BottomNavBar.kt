package com.example.assignment.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun BottomNavBar(
    navController: NavController,
    onHomeClick: () -> Unit
) {

    NavigationBar {

        NavigationBarItem(
            selected = false,
            onClick = {
                navController.navigate("home")
                onHomeClick()
            },
            icon = {
                Icon(Icons.Default.Home, contentDescription = null)
            }
        )

        NavigationBarItem(
            selected = false,
            onClick = { navController.navigate("search") },
            icon = {
                Icon(Icons.Default.Search, contentDescription = null)
            }
        )

        NavigationBarItem(
            selected = false,
            onClick = { navController.navigate("reels") },
            icon = {
                Icon(Icons.Default.PlayArrow, contentDescription = null)
            }
        )

        NavigationBarItem(
            selected = false,
            onClick = { navController.navigate("profile") },
            icon = {
                Icon(Icons.Default.Person, contentDescription = null)
            }
        )
    }
}