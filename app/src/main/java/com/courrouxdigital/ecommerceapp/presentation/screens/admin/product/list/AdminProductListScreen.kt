package com.courrouxdigital.ecommerceapp.presentation.screens.admin.product.list

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.courrouxdigital.ecommerceapp.presentation.screens.admin.product.list.components.AdminProductListContent
import com.courrouxdigital.ecommerceapp.presentation.screens.client.product.list.components.ClientProductListContent

@Composable
fun AdminProductListScreen() {
    Scaffold {
        AdminProductListContent(
            modifier = Modifier.padding(it)
        )
    }
}