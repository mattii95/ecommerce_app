package com.courrouxdigital.ecommerceapp.presentation.screens.admin.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.courrouxdigital.ecommerceapp.presentation.components.CustomBottomBar
import com.courrouxdigital.ecommerceapp.presentation.navigation.graph.AdminNavGraph
import com.courrouxdigital.ecommerceapp.presentation.navigation.screen.AdminScreen
import com.courrouxdigital.ecommerceapp.presentation.navigation.screen.ClientScreen

@Composable
fun AdminHomeScreen(navController: NavHostController = rememberNavController()) {

    val screens = listOf(
        AdminScreen.ProductList,
        AdminScreen.CategoryList,
        AdminScreen.Profile,
    )

    Scaffold(
        bottomBar = {
            CustomBottomBar(navController, screens)
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier.padding(innerPadding)
        ) {
            AdminNavGraph(navController)
        }
    }
}