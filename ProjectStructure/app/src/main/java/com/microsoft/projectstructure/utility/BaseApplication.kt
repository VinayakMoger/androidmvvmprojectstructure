/*
Created by Vinayak
 */
package com.microsoft.projectstructure.utility

import android.app.Application
import com.microsoft.projectstructure.data.local.MyPreference
import com.microsoft.projectstructure.data.repository.NetworkRepository
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class BaseApplication : Application() {

    @Inject
    lateinit var myPreference: MyPreference
    @Inject
    lateinit var repository: NetworkRepository

}