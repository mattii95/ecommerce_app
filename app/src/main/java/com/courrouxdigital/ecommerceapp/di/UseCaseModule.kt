package com.courrouxdigital.ecommerceapp.di

import com.courrouxdigital.ecommerceapp.data.repositories.datasource.AuthRemoteDatasource
import com.courrouxdigital.ecommerceapp.data.repositories.datasourceimpl.AuthRemoteDatasourceImpl
import com.courrouxdigital.ecommerceapp.data.service.AuthService
import com.courrouxdigital.ecommerceapp.domain.repositories.AuthRepository
import com.courrouxdigital.ecommerceapp.domain.usecases.auth.AuthUseCase
import com.courrouxdigital.ecommerceapp.domain.usecases.auth.GetSessionUseCase
import com.courrouxdigital.ecommerceapp.domain.usecases.auth.LoginUseCase
import com.courrouxdigital.ecommerceapp.domain.usecases.auth.RegisterUseCase
import com.courrouxdigital.ecommerceapp.domain.usecases.auth.SaveSessionUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun provideAuthUseCase(authRepository: AuthRepository) = AuthUseCase(
        login = LoginUseCase(authRepository),
        register = RegisterUseCase(authRepository),
        saveSession = SaveSessionUseCase(authRepository),
        getSession = GetSessionUseCase(authRepository)
    )
}