package com.courrouxdigital.ecommerceapp.presentation.screens.roles.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil3.compose.AsyncImage
import com.courrouxdigital.ecommerceapp.presentation.navigation.Graph
import com.courrouxdigital.ecommerceapp.presentation.screens.roles.RolesViewModel
import com.courrouxdigital.ecommerceapp.ui.theme.EcommerceAppTheme

@Composable
fun RolesContent(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    viewModel: RolesViewModel = hiltViewModel(),
) {
    val state by viewModel.state.collectAsState()
    val roles = state.response?.user?.roles

    LazyColumn(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        roles?.let {
            items(
                items = roles
            ) { rol ->
                Column(
                    modifier = Modifier
                        .padding(vertical = 32.dp)
                        .clickable {
                            navController.navigate(route = rol.route) {
                                popUpTo(route = Graph.ROLES) { inclusive = true }
                            }
                        },
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    AsyncImage(
                        modifier = Modifier
                            .height(150.dp)
                            .width(150.dp),
                        model = rol.image_url,
                        contentDescription = ""
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    Text(
                        text = rol.name,
                        style = MaterialTheme.typography.headlineMedium
                    )
                }
            }
        }

    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun RolesContentPreview() {
    EcommerceAppTheme {
        RolesContent(navController = rememberNavController())
    }
}