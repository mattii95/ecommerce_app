package com.courrouxdigital.ecommerceapp.presentation.screens.roles

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.courrouxdigital.ecommerceapp.domain.usecases.auth.AuthUseCase
import com.courrouxdigital.ecommerceapp.presentation.screens.roles.RolesState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RolesViewModel @Inject constructor(
    private val authUseCase: AuthUseCase
): ViewModel() {

    private val _state = MutableStateFlow(RolesState())
    var state: StateFlow<RolesState> = _state.asStateFlow()

    init {
        getSession()
    }

    fun getSession() = viewModelScope.launch {
        authUseCase.getSession().collect { data ->
            if (!data.token.isNullOrBlank()) {
                _state.update { it.copy(response = data) }
            }
        }
    }
}