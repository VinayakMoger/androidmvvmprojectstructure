package com.microsoft.projectstructure.data.remote


import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val webservice: Webservice
): BaseDataSource() {
    suspend fun getTestData() = getResult { webservice.testAPI() }

}