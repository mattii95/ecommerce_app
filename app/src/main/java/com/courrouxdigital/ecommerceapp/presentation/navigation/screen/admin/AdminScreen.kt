package com.courrouxdigital.ecommerceapp.presentation.navigation.screen.admin

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.List
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.ThumbUp
import androidx.compose.ui.graphics.vector.ImageVector
import com.courrouxdigital.ecommerceapp.presentation.navigation.model.BottomBarItem

sealed class AdminScreen(
    override val route: String,
    override val title: String,
    override val icon: ImageVector
) : BottomBarItem {
    object CategoryList: AdminScreen(
        route = "admin/category/list",
        title = "Categorias",
        icon = Icons.AutoMirrored.Outlined.List
    )
    object ProductList: AdminScreen(
        route = "admin/product/list",
        title = "Productos",
        icon = Icons.Outlined.ThumbUp
    )
    object Profile: AdminScreen(
        route = "admin/profile",
        title = "Perfil",
        icon = Icons.Outlined.Person
    )
}