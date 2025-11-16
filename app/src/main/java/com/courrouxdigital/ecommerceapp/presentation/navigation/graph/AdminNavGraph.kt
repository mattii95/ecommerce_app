package com.courrouxdigital.ecommerceapp.presentation.navigation.graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.courrouxdigital.ecommerceapp.presentation.navigation.Graph
import com.courrouxdigital.ecommerceapp.presentation.navigation.screen.AdminScreen
import com.courrouxdigital.ecommerceapp.presentation.navigation.screen.ClientScreen
import com.courrouxdigital.ecommerceapp.presentation.screens.admin.category.list.AdminCategoryListScreen
import com.courrouxdigital.ecommerceapp.presentation.screens.admin.product.list.AdminProductListScreen
import com.courrouxdigital.ecommerceapp.presentation.screens.client.category.list.ClientCategoryListScreen
import com.courrouxdigital.ecommerceapp.presentation.screens.client.product.list.ClientProductListScreen
import com.courrouxdigital.ecommerceapp.presentation.screens.profile.ProfileScreen

@Composable
fun AdminNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Graph.ADMIN,
        startDestination = AdminScreen.ProductList.route
    ) {
        composable(route = AdminScreen.ProductList.route) {
            AdminProductListScreen()
        }

        composable(route = AdminScreen.CategoryList.route) {
            AdminCategoryListScreen()
        }

        composable(route = AdminScreen.Profile.route) {
            ProfileScreen()
        }
    }
}