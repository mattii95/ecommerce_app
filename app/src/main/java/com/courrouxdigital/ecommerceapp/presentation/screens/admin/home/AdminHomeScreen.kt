package com.courrouxdigital.ecommerceapp.presentation.screens.admin.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.courrouxdigital.ecommerceapp.presentation.components.CustomBottomBar
import com.courrouxdigital.ecommerceapp.presentation.navigation.graph.admin.AdminNavGraph
import com.courrouxdigital.ecommerceapp.presentation.navigation.screen.admin.AdminScreen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
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
        AdminNavGraph(navController)
    }
}