/*
Created by Vinayak
 */

package com.microsoft.projectstructure.utility

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers

fun <T> performGetOperation(networkCall: suspend () -> Resource<T>): LiveData<Resource<T>> =
    liveData(Dispatchers.IO) {
        emit(Resource.loading(null))
        val responseStatus = networkCall.invoke()
        if (responseStatus.status == Status.SUCCESS) {
            emit(Resource.success(data = responseStatus.data!!))
        } else if (responseStatus.status == Status.ERROR) {
            emit(Resource.error(message = responseStatus.message!!, data = null))
        }
    }