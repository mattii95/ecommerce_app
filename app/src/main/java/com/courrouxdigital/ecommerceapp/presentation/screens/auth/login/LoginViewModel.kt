package com.courrouxdigital.ecommerceapp.presentation.screens.auth.login

import android.util.Patterns
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor() : ViewModel() {

    private val _state = MutableStateFlow(LoginState())
    var state: StateFlow<LoginState> = _state.asStateFlow()

    fun onEmailChange(newValue: String) {
        _state.update { it.copy(email = newValue) }
    }

    fun onPasswordChange(newValue: String) {
        _state.update { it.copy(password = newValue) }
    }

    fun clearMessage() {
        _state.update { it.copy(errorMessage = "") }
    }

    fun validateForm() {
        if (!Patterns.EMAIL_ADDRESS.matcher(state.value.email).matches()) {
            _state.update { it.copy(errorMessage = "Email no valido") }
            return
        }

        if (state.value.password.length < 6) {
            _state.update { it.copy(errorMessage = "La contraseña debe terner minimo 6 caracteres") }
            return
        }

        _state.update { it.copy(errorMessage = "") }
    }

}