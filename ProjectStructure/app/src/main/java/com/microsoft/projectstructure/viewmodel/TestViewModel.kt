package com.microsoft.projectstructure.viewmodel

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.microsoft.projectstructure.data.entities.response.TestResponseModel
import com.microsoft.projectstructure.data.repository.NetworkRepository
import com.microsoft.projectstructure.utility.BaseApplication
import com.microsoft.projectstructure.utility.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TestViewModel @Inject constructor(
    myApplication: BaseApplication,
    private val repository: NetworkRepository
) : AndroidViewModel(myApplication) {
    fun getTestData() : LiveData<Resource<TestResponseModel>>  = repository.gettestData()
}