package com.courrouxdigital.ecommerceapp.presentation.screens.client.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.courrouxdigital.ecommerceapp.presentation.components.CustomBottomBar
import com.courrouxdigital.ecommerceapp.presentation.navigation.graph.client.ClientNavGraph
import com.courrouxdigital.ecommerceapp.presentation.navigation.screen.client.ClientScreen

@Composable
fun ClientHomeScreen(navController: NavHostController = rememberNavController()) {

    val screens = listOf(
        ClientScreen.ProductList,
        ClientScreen.CategoryList,
        ClientScreen.Profile,
    )

    Scaffold(
        bottomBar = {
            CustomBottomBar(navController, screens)
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier.padding(innerPadding)
        ) {
            ClientNavGraph(navController)
        }
    }
}