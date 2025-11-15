package com.courrouxdigital.ecommerceapp.presentation.screens.auth.register

import android.util.Log
import android.util.Patterns
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.courrouxdigital.ecommerceapp.domain.models.AuthResponse
import com.courrouxdigital.ecommerceapp.domain.models.User
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
class RegisterViewModel @Inject constructor(private val authUseCase: AuthUseCase) : ViewModel() {
    private val _state = MutableStateFlow(RegisterState())
    var state: StateFlow<RegisterState> = _state.asStateFlow()

    fun register() = viewModelScope.launch {
        val formState = _state.value

        if (!formState.isValidForm) return@launch

        _state.update { it.copy(response = Resource.Loading) }

        val user = User(
            name = formState.name,
            lastname = formState.lastname,
            email = formState.email,
            phone = formState.phone,
            password = formState.password
        )

        val result = authUseCase.register(user)

        _state.update { it.copy(response = result) }
        Log.d("RegisterViewModel", "Response ${state.value.response}")
    }

    fun saveSession(authResponse: AuthResponse) = viewModelScope.launch {
        authUseCase.saveSession(authResponse)
    }

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

    fun clearStatus() {
        _state.update { it.copy(response = null) }
    }

    fun validateForm() {

        if (state.value.name == "") {
            _state.update {
                it.copy(
                    errorMessage = "El nombre es obligatorio",
                    isValidForm = false
                )
            }
            return
        }

        if (state.value.lastname == "") {
            _state.update {
                it.copy(
                    errorMessage = "El apellido es obligatorio",
                    isValidForm = false
                )
            }
            return
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(state.value.email).matches()) {
            _state.update {
                it.copy(
                    errorMessage = "Email no valido",
                    isValidForm = false
                )
            }
            return
        }

        if (state.value.phone == "") {
            _state.update {
                it.copy(
                    errorMessage = "El telefono es obligatorio",
                    isValidForm = false
                )
            }
            return
        }

        if (state.value.password.length < 6) {
            _state.update {
                it.copy(
                    errorMessage = "La contraseña debe terner minimo 6 caracteres",
                    isValidForm = false
                )
            }
            return
        }

        if (state.value.confirmPassword != state.value.password) {
            _state.update {
                it.copy(
                    errorMessage = "Las contraseñas no coinciden",
                    isValidForm = false
                )
            }
            return
        }

        _state.update {
            it.copy(
                errorMessage = "",
                isValidForm = true
            )
        }
    }

}