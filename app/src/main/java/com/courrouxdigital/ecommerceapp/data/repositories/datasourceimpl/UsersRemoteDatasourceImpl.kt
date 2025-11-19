package com.courrouxdigital.ecommerceapp.data.repositories.datasourceimpl

import com.courrouxdigital.ecommerceapp.data.repositories.datasource.UsersRemoteDatasource
import com.courrouxdigital.ecommerceapp.data.service.UsersService
import com.courrouxdigital.ecommerceapp.domain.models.User
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import retrofit2.Response
import java.io.File

class UsersRemoteDatasourceImpl(private val usersService: UsersService) : UsersRemoteDatasource {
    override suspend fun register(user: User): Response<User> {
        return usersService.update(id = "${user.id}", user = user)
    }

    override suspend fun registerWithImage(
        user: User,
        file: File,
    ): Response<User> {
        val connection = file.toURI().toURL().openConnection()
        val mimeTye = connection.contentType
        val contentType = "text/plain"
        val requestFile = file.asRequestBody(mimeTye.toMediaTypeOrNull())
        val fileFormData = MultipartBody.Part.createFormData("file", file.name, requestFile)
        val nameData = user.name.toRequestBody(contentType.toMediaTypeOrNull())
        val lastnameData = user.lastname.toRequestBody(contentType.toMediaTypeOrNull())
        val phoneData = user.phone.toRequestBody(contentType.toMediaTypeOrNull())

        return usersService.updateWithImage(
            id = "${user.id}",
            name = nameData,
            lastname = lastnameData,
            phone = phoneData,
            file = fileFormData
        )
    }
}