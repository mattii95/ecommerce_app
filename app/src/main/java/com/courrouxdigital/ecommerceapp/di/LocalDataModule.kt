package com.courrouxdigital.ecommerceapp.di

import com.courrouxdigital.ecommerceapp.data.datastore.AuthDataStore
import com.courrouxdigital.ecommerceapp.data.repositories.datasource.AuthLocalDatasource
import com.courrouxdigital.ecommerceapp.data.repositories.datasourceimpl.AuthLocalDatasourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object LocalDataModule {

    @Provides
    fun provideAuthLocalDataSource(authDataStore: AuthDataStore): AuthLocalDatasource =
        AuthLocalDatasourceImpl(authDataStore)
}