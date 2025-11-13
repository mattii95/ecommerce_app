package com.courrouxdigital.ecommerceapp.presentation.screens.auth.register

import android.util.Patterns
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor() : ViewModel() {
    private val _state = MutableStateFlow(RegisterState())
    var state: StateFlow<RegisterState> = _state.asStateFlow()

    fun onNameChange(newValue: String) {
        _state.update { it.copy(name = newValue) }
    }

    fun onLastnameChange(newValue: String) {
        _state.update { it.copy(lastname = newValue) }
    }

    fun onEmailChange(newValue: String) {
        _state.update { it.copy(email = newValue) }
    }

    fun onPhoneChange(newValue: String) {
        _state.update { it.copy(phone = newValue) }
    }

    fun onPasswordChange(newValue: String) {
        _state.update { it.copy(password = newValue) }
    }

    fun onConfirmPasswordChange(newValue: String) {
        _state.update { it.copy(confirmPassword = newValue) }
    }

    fun clearMessage() {
        _state.update { it.copy(errorMessage = "") }
    }

    fun validateForm() {

        if (state.value.name == "") {
            _state.update { it.copy(errorMessage = "El nombre es obligatorio") }
            return
        }

        if (state.value.lastname == "") {
            _state.update { it.copy(errorMessage = "El apellido es obligatorio") }
            return
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(state.value.email).matches()) {
            _state.update { it.copy(errorMessage = "Email no valido") }
            return
        }

        if (state.value.phone == "") {
            _state.update { it.copy(errorMessage = "El telefono es obligatorio") }
            return
        }

        if (state.value.password.length < 6) {
            _state.update { it.copy(errorMessage = "La contraseña debe terner minimo 6 caracteres") }
            return
        }

        if (state.value.confirmPassword != state.value.password) {
            _state.update { it.copy(errorMessage = "Las contraseñas no coinciden") }
            return
        }

        _state.update { it.copy(errorMessage = "") }
    }

}