package com.courrouxdigital.ecommerceapp.presentation.screens.roles.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage

@Composable
fun RolItem() {
    ElevatedCard(
        modifier = Modifier
            .clickable {
//                            navController.navigate(route = rol.route) {
//                                popUpTo(route = AuthScreen.Roles.route) { inclusive = true }
//                            }
            },
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AsyncImage(
                modifier = Modifier
                    .height(150.dp)
                    .width(150.dp),
                model = "https://res.cloudinary.com/daff1zdaz/image/upload/v1763063887/client_ujelcj.png",
                contentDescription = ""
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = "Client",
                style = MaterialTheme.typography.headlineMedium
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun RolItemPreview() {
    RolItem()
}