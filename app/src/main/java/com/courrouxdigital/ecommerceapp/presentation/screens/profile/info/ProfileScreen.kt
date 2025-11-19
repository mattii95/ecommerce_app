package com.courrouxdigital.ecommerceapp.presentation.screens.profile.info

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.courrouxdigital.ecommerceapp.presentation.screens.profile.info.components.ProfileContent

@Composable
fun ProfileScreen(navController: NavHostController) {
    Scaffold {
        ProfileContent(
            modifier = Modifier.padding(it),
            navController = navController
        )
    }
}