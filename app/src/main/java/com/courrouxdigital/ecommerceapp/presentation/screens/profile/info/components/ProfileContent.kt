package com.courrouxdigital.ecommerceapp.presentation.screens.profile.info.components

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ExitToApp
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.courrouxdigital.ecommerceapp.R
import com.courrouxdigital.ecommerceapp.presentation.MainActivity
import com.courrouxdigital.ecommerceapp.presentation.components.CustomButton
import com.courrouxdigital.ecommerceapp.presentation.components.CustomImage
import com.courrouxdigital.ecommerceapp.presentation.navigation.screen.profile.ProfileScreen
import com.courrouxdigital.ecommerceapp.presentation.screens.profile.info.ProfileViewModel
import com.courrouxdigital.ecommerceapp.presentation.ui.theme.EcommerceAppTheme

@SuppressLint("ContextCastToActivity")
@Composable
fun ProfileContent(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    viewModel: ProfileViewModel = hiltViewModel(),
) {
    val activity = LocalContext.current as? Activity

    val state by viewModel.state.collectAsState()
    val user = state.userData

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(
                color = MaterialTheme.colorScheme.primary
            )
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
        ) {

            IconButton(
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(16.dp),
                onClick = {
                    viewModel.logout()
                    activity?.let {
                        it.finish()
                        it.startActivity(Intent(it, MainActivity::class.java))
                    }
                }
            ) {
                Icon(
                    modifier = Modifier.size(35.dp),
                    imageVector = Icons.AutoMirrored.Outlined.ExitToApp,
                    contentDescription = "Logout",
                    tint = Color.White
                )
            }

            CustomImage(
                modifier = Modifier
                    .size(150.dp)
                    .clip(CircleShape)
                    .align(Alignment.CenterHorizontally),
                imageUrl = user?.imageUrl,
                placeholder = R.drawable.placeholder_user,
                fallback = R.drawable.user_image
            )

            Spacer(modifier = Modifier.weight(1f))

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 50.dp),
                shape = RoundedCornerShape(
                    topEnd = 30.dp,
                    topStart = 30.dp
                ),
            ) {

                Column(
                    modifier = Modifier
                        .padding(30.dp)
                        .verticalScroll(rememberScrollState())
                ) {
                    // Name
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Rounded.Person,
                            contentDescription = ""
                        )
                        Column(
                            modifier = Modifier.padding(horizontal = 5.dp)
                        ) {
                            Text(text = "${user?.name} ${user?.lastname}")
                            Text(
                                text = "Nombre de usuario",
                                fontSize = 12.sp,
                                color = MaterialTheme.colorScheme.tertiary
                            )
                        }
                    }

                    // Email
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Rounded.Email,
                            contentDescription = ""
                        )
                        Column(
                            modifier = Modifier.padding(horizontal = 5.dp)
                        ) {
                            Text(text = user?.email ?: "No email")
                            Text(
                                text = "Correo electronico",
                                fontSize = 12.sp,
                                color = MaterialTheme.colorScheme.tertiary
                            )
                        }
                    }

                    // Phone
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 32.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Rounded.Phone,
                            contentDescription = ""
                        )
                        Column(
                            modifier = Modifier.padding(horizontal = 5.dp)
                        ) {
                            Text(text = user?.phone ?: "")
                            Text(
                                text = "Telefono",
                                fontSize = 12.sp,
                                color = MaterialTheme.colorScheme.tertiary
                            )
                        }
                    }

                    CustomButton(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 16.dp),
                        text = "Actualizar",
                        onClick = {
                            navController.navigate(
                                route = ProfileScreen.ProfileUpdate.route
                            )
                        }
                    )
                }

            }


        }
    }

}

@Preview(showBackground = true)
@Composable
private fun ProfileContentPreview() {
    EcommerceAppTheme {
        ProfileContent(navController = rememberNavController())
    }
}