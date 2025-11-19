package com.courrouxdigital.ecommerceapp.di

import com.courrouxdigital.ecommerceapp.data.repositories.datasource.AuthRemoteDatasource
import com.courrouxdigital.ecommerceapp.data.repositories.datasourceimpl.AuthRemoteDatasourceImpl
import com.courrouxdigital.ecommerceapp.data.service.AuthService
import com.courrouxdigital.ecommerceapp.domain.repositories.AuthRepository
import com.courrouxdigital.ecommerceapp.domain.repositories.UsersRepository
import com.courrouxdigital.ecommerceapp.domain.usecases.auth.AuthUseCase
import com.courrouxdigital.ecommerceapp.domain.usecases.auth.GetSessionUseCase
import com.courrouxdigital.ecommerceapp.domain.usecases.auth.LoginUseCase
import com.courrouxdigital.ecommerceapp.domain.usecases.auth.LogoutUseCase
import com.courrouxdigital.ecommerceapp.domain.usecases.auth.RegisterUseCase
import com.courrouxdigital.ecommerceapp.domain.usecases.auth.SaveSessionUseCase
import com.courrouxdigital.ecommerceapp.domain.usecases.auth.UpdateSessionUseCase
import com.courrouxdigital.ecommerceapp.domain.usecases.users.UpdateUseWithImagerUseCase
import com.courrouxdigital.ecommerceapp.domain.usecases.users.UpdateUserUseCase
import com.courrouxdigital.ecommerceapp.domain.usecases.users.UsersUseCase
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
        updateSession = UpdateSessionUseCase(authRepository),
        getSession = GetSessionUseCase(authRepository),
        logout = LogoutUseCase(authRepository),
    )

    @Provides
    fun provideUsersUseCase(usersRepository: UsersRepository) = UsersUseCase(
        updateUser = UpdateUserUseCase(usersRepository),
        updateUserWithImage = UpdateUseWithImagerUseCase(usersRepository)
    )
}