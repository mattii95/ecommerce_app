package com.courrouxdigital.ecommerceapp.di

import com.courrouxdigital.ecommerceapp.data.repositories.AuthRepositoryImpl
import com.courrouxdigital.ecommerceapp.data.repositories.UsersRepositoryImpl
import com.courrouxdigital.ecommerceapp.data.repositories.datasource.AuthLocalDatasource
import com.courrouxdigital.ecommerceapp.data.repositories.datasource.AuthRemoteDatasource
import com.courrouxdigital.ecommerceapp.data.repositories.datasource.UsersRemoteDatasource
import com.courrouxdigital.ecommerceapp.domain.repositories.AuthRepository
import com.courrouxdigital.ecommerceapp.domain.repositories.UsersRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideAuthRepository(
        authRemoteDatasource: AuthRemoteDatasource,
        authLocalDatasource: AuthLocalDatasource,
    ): AuthRepository {
        return AuthRepositoryImpl(authRemoteDatasource, authLocalDatasource)
    }

    @Provides
    fun provideUsersRepository(usersRemoteDatasource: UsersRemoteDatasource): UsersRepository {
        return UsersRepositoryImpl(usersRemoteDatasource)
    }

}