package com.microsoft.projectstructure.data.remote

import com.microsoft.projectstructure.data.entities.response.*
import retrofit2.Response
import retrofit2.http.GET

interface Webservice {

    @GET("api/users/2")
    suspend fun testAPI(): Response<TestResponseModel>

}