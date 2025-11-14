package com.courrouxdigital.ecommerceapp.domain.utils

import com.courrouxdigital.ecommerceapp.domain.models.ErrorResponse
import okio.IOException
import retrofit2.HttpException
import retrofit2.Response

object ResponseToRequest {
    fun <T> executeAction(result: Response<T>): Resource<T> {
        return try {
            if (result.isSuccessful) {
                Resource.Success(result.body()!!)
            } else {
                val errorResponse: ErrorResponse? =
                    ConvertErrorBody.convertError(result.errorBody())
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