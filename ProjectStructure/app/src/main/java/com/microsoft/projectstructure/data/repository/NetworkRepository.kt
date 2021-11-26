package com.microsoft.projectstructure.data.repository

import com.microsoft.projectstructure.data.remote.RemoteDataSource
import com.microsoft.projectstructure.utility.performGetOperation
import javax.inject.Inject

class NetworkRepository @Inject constructor(
        private val remoteDataSource: RemoteDataSource
) {
    fun gettestData() = performGetOperation(
            networkCall = { remoteDataSource.getTestData() }
    )
}