package com.courrouxdigital.ecommerceapp.presentation.screens.auth.login

import android.util.Log
import android.util.Patterns
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.courrouxdigital.ecommerceapp.domain.usecases.auth.AuthUseCase
import com.courrouxdigital.ecommerceapp.domain.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val authUseCase: AuthUseCase,
) : ViewModel() {

    private val _state = MutableStateFlow(LoginState())
    var state: StateFlow<LoginState> = _state.asStateFlow()

    fun login() = viewModelScope.launch {
        if (!isValidForm()) return@launch

        _state.update { it.copy(response = Resource.Loading) }
        val result = authUseCase.login(
            email = state.value.email,
            password = state.value.password
        )
        _state.update { it.copy(response = result) }

        Log.d("LoginViewModel", "Response ${state.value.response}")
    }

    fun onEmailChange(newValue: String) {
        _state.update { it.copy(email = newValue) }
    }

    fun onPasswordChange(newValue: String) {
        _state.update { it.copy(password = newValue) }
    }

    fun clearMessage() {
        _state.update { it.copy(errorMessage = "") }
    }

    fun clearStatus() {
        _state.update { it.copy(response = null) }
    }

    fun isValidForm(): Boolean {
        if (!Patterns.EMAIL_ADDRESS.matcher(state.value.email).matches()) {
            _state.update { it.copy(errorMessage = "Email no valido") }
            return false
        }

        if (state.value.password.length < 6) {
            _state.update { it.copy(errorMessage = "La contraseña debe terner minimo 6 caracteres") }
            return false
        }

        _state.update { it.copy(errorMessage = "") }
        return true
    }

}