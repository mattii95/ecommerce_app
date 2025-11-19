package com.courrouxdigital.ecommerceapp.presentation.navigation.graph.profile

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.courrouxdigital.ecommerceapp.presentation.navigation.Graph
import com.courrouxdigital.ecommerceapp.presentation.navigation.screen.profile.ProfileScreen
import com.courrouxdigital.ecommerceapp.presentation.navigation.screen.roles.RolesScreen
import com.courrouxdigital.ecommerceapp.presentation.screens.admin.home.AdminHomeScreen
import com.courrouxdigital.ecommerceapp.presentation.screens.client.home.ClientHomeScreen
import com.courrouxdigital.ecommerceapp.presentation.screens.profile.update.ProfileUpdateScreen
import com.courrouxdigital.ecommerceapp.presentation.screens.roles.RolesScreen

fun NavGraphBuilder.profileNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.PROFILE,
        startDestination = ProfileScreen.ProfileUpdate.route
    ) {
        composable(
            route = ProfileScreen.ProfileUpdate.route,
        ) {
            ProfileUpdateScreen(navController)
        }
    }
}