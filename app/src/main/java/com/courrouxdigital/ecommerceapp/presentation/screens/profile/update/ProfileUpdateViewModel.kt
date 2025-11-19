package com.courrouxdigital.ecommerceapp.presentation.screens.profile.update

import android.net.Uri
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.courrouxdigital.ecommerceapp.domain.models.User
import com.courrouxdigital.ecommerceapp.domain.usecases.auth.AuthUseCase
import com.courrouxdigital.ecommerceapp.domain.usecases.users.UsersUseCase
import com.courrouxdigital.ecommerceapp.domain.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.io.File
import javax.inject.Inject

@HiltViewModel
class ProfileUpdateViewModel @Inject constructor(
    private val authUseCase: AuthUseCase,
    private val usersUseCase: UsersUseCase,
) : ViewModel() {

    private val _state = MutableStateFlow(ProfileUpdateState())
    var state: StateFlow<ProfileUpdateState> = _state.asStateFlow()

    init {
        loadData()
    }

    private fun loadData() = viewModelScope.launch {
        authUseCase.getSession().collect { (user, _) ->
            _state.update {
                it.copy(userData = user, imageUrl = user?.imageUrl)
            }
        }
    }

    fun update() = viewModelScope.launch {
        val updatedUser = _state.value.userData
        val file = _state.value.file

        if (updatedUser == null) {
            Log.e("ProfileUpdateViewModel", "Error: User data is null, cannot update")
            return@launch
        }

        _state.update { it.copy(response = Resource.Loading) }

        val result = if (file != null) {
            usersUseCase.updateUserWithImage(updatedUser, file)
        } else {
            usersUseCase.updateUser(updatedUser)
        }

        _state.update { it.copy(response = result) }

        Log.e("ProfileUpdateViewModel", "update: $updatedUser")
    }


    fun updateUserSession(userResponse: User) = viewModelScope.launch {
        _state.update { it.copy(userData = userResponse) }
        authUseCase.updateSession(userResponse)
    }

    fun onNameChange(newValue: String) {
        _state.update { currentState ->
            val updatedUser = currentState.userData?.copy(name = newValue)
            currentState.copy(userData = updatedUser)
        }
    }

    fun onLastnameChange(newValue: String) {
        _state.update { currentState ->
            val updatedUser = currentState.userData?.copy(lastname = newValue)
            currentState.copy(userData = updatedUser)
        }
    }

    fun onPhoneChange(newValue: String) {
        _state.update { currentState ->
            val updatedUser = currentState.userData?.copy(phone = newValue)
            currentState.copy(userData = updatedUser)
        }
    }

    fun onImageChange(imageUri: Uri, file: File) {
        _state.update {
            it.copy(
                imageUrl = imageUri.toString(),
                file = file
            )
        }
    }

    fun clearStatus() {
        _state.update { it.copy(response = null) }
    }
}