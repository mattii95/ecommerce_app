package com.courrouxdigital.ecommerceapp.domain.utils

import android.util.Log
import com.courrouxdigital.ecommerceapp.domain.models.ErrorResponse
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.ResponseBody

object ConvertErrorBody {
    fun convertError(errorBody: ResponseBody?): ErrorResponse? {
       return try {
            errorBody?.source()?.let {
                val moshi = Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()
                val moshiAdapter = moshi.adapter(ErrorResponse::class.java)
                moshiAdapter.fromJson(it)
            }
        } catch (e: Exception) {
            Log.e("ConvertErrorBody", "convertError: " + e.message)
            null
        }
    }
}