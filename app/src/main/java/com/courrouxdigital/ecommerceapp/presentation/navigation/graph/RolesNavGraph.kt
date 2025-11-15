package com.courrouxdigital.ecommerceapp.presentation.navigation.graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.courrouxdigital.ecommerceapp.presentation.navigation.Graph
import com.courrouxdigital.ecommerceapp.presentation.navigation.screen.RolesScreen
import com.courrouxdigital.ecommerceapp.presentation.screens.client.home.ClientHomeScreen
import com.courrouxdigital.ecommerceapp.presentation.screens.roles.RolesScreen

fun NavGraphBuilder.rolesNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.ROLES,
        startDestination = RolesScreen.Roles.route
    ) {
        composable(route = RolesScreen.Roles.route) {
            RolesScreen(navController)
        }
        composable(route = Graph.CLIENT) {
            ClientHomeScreen()
        }
    }
}