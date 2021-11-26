/*
Created by Vinayak
 */
package com.microsoft.projectstructure.data.local

import android.annotation.SuppressLint
import android.content.SharedPreferences
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MyPreference @Inject constructor(){
    @Inject lateinit var sharedPreferences : SharedPreferences
    @SuppressLint("CommitPrefEdits")
    fun insertSessionData(key:String, value:Any?) {
        val editor = sharedPreferences.edit()
        when (value) {
            is String -> editor.putString(key,value)
            is Int -> editor.putInt(key,value)
            is Boolean -> editor.putBoolean(key,value)
            else -> editor.putString(key,"")
        }
        editor.apply()
    }


}