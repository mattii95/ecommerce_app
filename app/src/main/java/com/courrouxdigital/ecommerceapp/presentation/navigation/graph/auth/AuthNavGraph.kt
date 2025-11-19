package com.courrouxdigital.ecommerceapp.presentation.navigation.graph.auth

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.courrouxdigital.ecommerceapp.presentation.navigation.Graph
import com.courrouxdigital.ecommerceapp.presentation.navigation.screen.auth.AuthScreen
import com.courrouxdigital.ecommerceapp.presentation.screens.auth.login.LoginView
import com.courrouxdigital.ecommerceapp.presentation.screens.auth.register.RegisterView

fun NavGraphBuilder.authNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.AUTH,
        startDestination = AuthScreen.Login.route
    ) {
        composable(route = AuthScreen.Login.route) {
            LoginView(navController)
        }

        composable(route = AuthScreen.Register.route) {
            RegisterView(navController)
        }
    }
}