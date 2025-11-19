package com.courrouxdigital.ecommerceapp.di

import com.courrouxdigital.ecommerceapp.data.repositories.datasource.AuthRemoteDatasource
import com.courrouxdigital.ecommerceapp.data.repositories.datasource.UsersRemoteDatasource
import com.courrouxdigital.ecommerceapp.data.repositories.datasourceimpl.AuthRemoteDatasourceImpl
import com.courrouxdigital.ecommerceapp.data.repositories.datasourceimpl.UsersRemoteDatasourceImpl
import com.courrouxdigital.ecommerceapp.data.service.AuthService
import com.courrouxdigital.ecommerceapp.data.service.UsersService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RemoteDataModule {

    @Provides
    fun provideAuthRemoteDataSource(authService: AuthService): AuthRemoteDatasource =
        AuthRemoteDatasourceImpl(authService)

    @Provides
    fun provideUsersRemoteDataSource(usersService: UsersService): UsersRemoteDatasource =
        UsersRemoteDatasourceImpl(usersService)
}