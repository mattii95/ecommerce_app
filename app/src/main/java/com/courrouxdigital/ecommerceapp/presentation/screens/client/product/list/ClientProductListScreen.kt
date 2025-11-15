package com.courrouxdigital.ecommerceapp.presentation.screens.client.product.list

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.courrouxdigital.ecommerceapp.presentation.screens.client.category.list.components.ClientCategoryListContent
import com.courrouxdigital.ecommerceapp.presentation.screens.client.product.list.components.ClientProductListContent

@Composable
fun ClientProductListScreen() {
    Scaffold {
        ClientProductListContent(
            modifier = Modifier.padding(it)
        )
    }
}