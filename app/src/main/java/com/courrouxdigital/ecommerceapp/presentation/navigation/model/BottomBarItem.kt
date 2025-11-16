package com.courrouxdigital.ecommerceapp.presentation.navigation.model

import androidx.compose.ui.graphics.vector.ImageVector

interface BottomBarItem {
    val route: String
    val title: String
    val icon: ImageVector
}