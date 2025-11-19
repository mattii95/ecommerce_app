package com.courrouxdigital.ecommerceapp.presentation.screens.client.category.list

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.courrouxdigital.ecommerceapp.presentation.screens.client.category.list.components.ClientCategoryListContent

@Composable
fun ClientCategoryListScreen() {
    Scaffold {
        ClientCategoryListContent(
            modifier = Modifier.padding(it)
        )
    }
}