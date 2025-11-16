package com.courrouxdigital.ecommerceapp.presentation.screens.admin.category.list

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.courrouxdigital.ecommerceapp.presentation.screens.admin.category.list.components.AdminCategoryListContent
import com.courrouxdigital.ecommerceapp.presentation.screens.client.category.list.components.ClientCategoryListContent

@Composable
fun AdminCategoryListScreen() {
    Scaffold {
        AdminCategoryListContent(
            modifier = Modifier.padding(it)
        )
    }
}