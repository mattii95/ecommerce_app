package com.courrouxdigital.ecommerceapp.presentation.screens.profile.components

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.courrouxdigital.ecommerceapp.presentation.MainActivity
import com.courrouxdigital.ecommerceapp.presentation.components.CustomButton
import com.courrouxdigital.ecommerceapp.presentation.screens.profile.ProfileViewModel
import com.courrouxdigital.ecommerceapp.ui.theme.EcommerceAppTheme

@SuppressLint("ContextCastToActivity")
@Composable
fun ProfileContent(
    modifier: Modifier = Modifier,
    viewModel: ProfileViewModel = hiltViewModel()
) {

    val state by viewModel.state.collectAsState()
    val activity = LocalContext.current as? Activity

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Hola, ${state.session?.user?.name}")
        CustomButton(
            text = "Cerrar Sesion",
            onClick = {
                viewModel.logout()
                activity?.let {
                    it.finish()
                    it.startActivity(Intent(it, MainActivity::class.java))
                }
            }
        )
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun ProfileContentPreview() {
    EcommerceAppTheme {
        ProfileContent()
    }
}