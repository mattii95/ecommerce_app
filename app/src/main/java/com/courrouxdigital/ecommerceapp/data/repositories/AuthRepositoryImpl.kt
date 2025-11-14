package com.courrouxdigital.ecommerceapp.data.repositories

import com.courrouxdigital.ecommerceapp.data.repositories.datasource.AuthRemoteDatasource
import com.courrouxdigital.ecommerceapp.domain.models.AuthResponse
import com.courrouxdigital.ecommerceapp.domain.models.ErrorResponse
import com.courrouxdigital.ecommerceapp.domain.repositories.AuthRepository
import com.courrouxdigital.ecommerceapp.domain.utils.ConvertErrorBody
import com.courrouxdigital.ecommerceapp.domain.utils.Resource
import okio.IOException
import retrofit2.HttpException

class AuthRepositoryImpl(
    private val authRemoteDatasource: AuthRemoteDatasource,
) : AuthRepository {
    override suspend fun login(
        email: String,
        password: String,
    ): Resource<AuthResponse> {
        return try {
            val result = authRemoteDatasource.login(email, password)
            if (result.isSuccessful) {
                Resource.Success(result.body()!!)
            } else {
                val errorResponse: ErrorResponse? = ConvertErrorBody.convertError(result.errorBody())
                Resource.Error(errorResponse?.message ?: "Error desconocido")
            }
        } catch (e: HttpException) {
            e.printStackTrace()
            Resource.Error(e.message ?: "Error desconocido en la peticion")
        } catch (e: IOException) {
            e.printStackTrace()
            Resource.Error("Verifica tu conexion a internet")
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: "Error desconocido")
        }
    }
}