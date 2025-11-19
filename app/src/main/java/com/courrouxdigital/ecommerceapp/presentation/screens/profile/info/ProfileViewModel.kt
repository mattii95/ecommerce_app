package com.courrouxdigital.ecommerceapp.presentation.screens.profile.info

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.courrouxdigital.ecommerceapp.domain.usecases.auth.AuthUseCase
import com.courrouxdigital.ecommerceapp.presentation.screens.profile.info.ProfileState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val authUseCase: AuthUseCase,
) : ViewModel() {

    private val _state = MutableStateFlow(ProfileState())
    var state: StateFlow<ProfileState> = _state.asStateFlow()

    init {
        getSession()
    }

    fun logout() = viewModelScope.launch {
        authUseCase.logout()
    }

    fun getSession() = viewModelScope.launch {
        authUseCase.getSession().collect { data ->
            _state.update { it.copy(userData = data.user) }
        }
    }
}