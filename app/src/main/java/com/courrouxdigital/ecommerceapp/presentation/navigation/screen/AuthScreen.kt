package com.courrouxdigital.ecommerceapp.presentation.navigation.screen

sealed class AuthScreen(val route: String) {
    object Login: AuthScreen("login")
    object Register: AuthScreen("register")
}