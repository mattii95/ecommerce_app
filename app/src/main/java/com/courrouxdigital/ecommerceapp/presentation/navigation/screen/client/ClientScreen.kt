package com.courrouxdigital.ecommerceapp.presentation.navigation.screen.client

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.List
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.ThumbUp
import androidx.compose.ui.graphics.vector.ImageVector
import com.courrouxdigital.ecommerceapp.presentation.navigation.model.BottomBarItem

sealed class ClientScreen(
    override val route: String,
    override val title: String,
    override val icon: ImageVector
) : BottomBarItem {
    object CategoryList: ClientScreen(
        route = "client/category/list",
        title = "Categorias",
        icon = Icons.AutoMirrored.Outlined.List
    )
    object ProductList: ClientScreen(
        route = "client/product/list",
        title = "Productos",
        icon = Icons.Outlined.ThumbUp
    )
    object Profile: ClientScreen(
        route = "client/profile",
        title = "Perfil",
        icon = Icons.Outlined.Person
    )
}