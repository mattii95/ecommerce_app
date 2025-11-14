package com.courrouxdigital.ecommerceapp.presentation.screens.auth.register.components

import android.widget.Toast
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.courrouxdigital.ecommerceapp.presentation.components.CustomButton
import com.courrouxdigital.ecommerceapp.presentation.components.CustomTextField
import com.courrouxdigital.ecommerceapp.presentation.screens.auth.register.RegisterViewModel

@Composable
fun RegisterFormContent(
    viewModel: RegisterViewModel = hiltViewModel()
) {

    val state by viewModel.state.collectAsState()

    val context = LocalContext.current

    LaunchedEffect(key1 = state.errorMessage) {
        if (state.errorMessage != "") {
            Toast.makeText(context, state.errorMessage, Toast.LENGTH_LONG).show()
            viewModel.clearMessage()
        }
    }

    // Name
    CustomTextField(
        modifier = Modifier.fillMaxWidth(),
        value = state.name,
        onValueChange = { viewModel.onNameChange(it) },
        label = "Nombres",
        icon = Icons.Default.Person
    )
    Spacer(modifier = Modifier.height(16.dp))

    // Surname
    CustomTextField(
        modifier = Modifier.fillMaxWidth(),
        value = state.lastname,
        onValueChange = { viewModel.onLastnameChange(it) },
        label = "Apellidos",
        icon = Icons.Outlined.Person
    )
    Spacer(modifier = Modifier.height(16.dp))

    // Email
    CustomTextField(
        modifier = Modifier.fillMaxWidth(),
        value = state.email,
        onValueChange = { viewModel.onEmailChange(it) },
        label = "Correo Electronico",
        icon = Icons.Default.Email,
        keyboardType = KeyboardType.Email
    )
    Spacer(modifier = Modifier.height(16.dp))

    // Phone
    CustomTextField(
        modifier = Modifier.fillMaxWidth(),
        value = state.phone,
        onValueChange = { viewModel.onPhoneChange(it) },
        label = "Telefono",
        icon = Icons.Default.Phone,
        keyboardType = KeyboardType.Phone
    )
    Spacer(modifier = Modifier.height(16.dp))

    // Password
    CustomTextField(
        modifier = Modifier.fillMaxWidth(),
        value = state.password,
        onValueChange = { viewModel.onPasswordChange(it) },
        label = "Contraseña",
        icon = Icons.Default.Lock,
        keyboardType = KeyboardType.Password,
        hideText = true
    )
    Spacer(modifier = Modifier.height(16.dp))

    // Password
    CustomTextField(
        modifier = Modifier.fillMaxWidth(),
        value = state.confirmPassword,
        onValueChange = { viewModel.onConfirmPasswordChange(it) },
        label = "Repetir Contraseña",
        icon = Icons.Outlined.Lock,
        keyboardType = KeyboardType.Password,
        hideText = true
    )
    Spacer(modifier = Modifier.height(32.dp))

    // Button
    CustomButton(
        modifier = Modifier.fillMaxWidth(),
        text = "Confirmar",
        onClick = {
            viewModel.validateForm()
            viewModel.register()
        }
    )
}