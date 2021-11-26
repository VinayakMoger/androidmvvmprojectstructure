package com.microsoft.projectstructure.data.remote

import com.microsoft.projectstructure.utility.Resource
import com.microsoft.projectstructure.utility.getErrorResponse
import org.json.JSONObject
import retrofit2.Response

abstract class BaseDataSource {

    protected suspend fun <T> getResult(call: suspend () -> Response<T>): Resource<T> {
        try {
            val response = call()
            if (response.isSuccessful) {
                val body = response.body()
                if (body != null) return Resource.success(body)
            }
            val jsonObj = JSONObject(response.errorBody()!!.charStream().readText())
            return error(getErrorResponse(jsonObj))
        } catch (e: Exception) {
            return error("")
        }
    }

    private fun <T> error(message: String): Resource<T> {
        return Resource.error(message =message,data = null)
    }
}