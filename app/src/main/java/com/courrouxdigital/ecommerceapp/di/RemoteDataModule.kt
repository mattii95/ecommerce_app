package com.courrouxdigital.ecommerceapp.di

import com.courrouxdigital.ecommerceapp.data.repositories.datasource.AuthRemoteDatasource
import com.courrouxdigital.ecommerceapp.data.repositories.datasourceimpl.AuthRemoteDatasourceImpl
import com.courrouxdigital.ecommerceapp.data.service.AuthService
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
}