package com.courrouxdigital.ecommerceapp.data.service

import com.courrouxdigital.ecommerceapp.domain.models.AuthResponse
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST


interface AuthService {
    @FormUrlEncoded
    @POST("/auth/login")
    suspend fun login(
        @Field("email") email: String,
        @Field("password") password: String,
    ): Response<AuthResponse>
}