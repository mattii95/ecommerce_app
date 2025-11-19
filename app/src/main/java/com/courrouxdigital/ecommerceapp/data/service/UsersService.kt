package com.courrouxdigital.ecommerceapp.data.service

import com.courrouxdigital.ecommerceapp.domain.models.User
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Multipart
import retrofit2.http.PATCH
import retrofit2.http.Part
import retrofit2.http.Path

interface UsersService {

    @PATCH("/users/{id}")
    suspend fun update(
        @Path("id") id: String,
        @Body() user: User
    ): Response<User>

    @Multipart
    @PATCH("/users/{id}/upload-image")
    suspend fun updateWithImage(
        @Path("id") id: String,
        @Part("name") name: RequestBody,
        @Part("lastname") lastname: RequestBody,
        @Part("phone") phone: RequestBody,
        @Part file: MultipartBody.Part
    ): Response<User>

}