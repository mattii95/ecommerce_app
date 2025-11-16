package com.courrouxdigital.ecommerceapp.presentation.components

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.courrouxdigital.ecommerceapp.presentation.navigation.model.BottomBarItem

@Composable
fun CustomBottomBar(
    navHostController: NavHostController,
    screens: List<BottomBarItem>,
) {
    val navBackStackEntry by navHostController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    val shouldShow = screens.any { it.route == currentDestination?.route }
    if (!shouldShow) return

    NavigationBar {
        screens.forEach { screen ->
            val selected = currentDestination?.hierarchy?.any {
                it.route == screen.route
            } == true

            NavigationBarItem(
                label = {
                    Text(text = screen.title)
                },
                icon = {
                    Icon(imageVector = screen.icon, contentDescription = screen.title)
                },
                selected = selected,
                onClick = {
                    if (!selected) {
                        navHostController.navigate(screen.route) {
                            popUpTo(navHostController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                }
            )
        }
    }
}