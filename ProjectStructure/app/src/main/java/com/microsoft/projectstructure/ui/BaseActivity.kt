/*
Created by Vinayak
Provides alert message and progress dialogue codes for all activities
 */

package com.microsoft.projectstructure.ui

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.InsetDrawable
import android.media.AudioManager
import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.microsoft.projectstructure.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
abstract class BaseActivity : AppCompatActivity() {
    lateinit var dialog: AlertDialog


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        volumeControlStream = AudioManager.STREAM_MUSIC
    }

    open fun showProgressDialog(app: Context) {
        try {
            val back = ColorDrawable(Color.TRANSPARENT)
            val inset = InsetDrawable(back, 20)
            val builder: AlertDialog.Builder = AlertDialog.Builder(app)
            val customLayout: View =
                    LayoutInflater.from(app).inflate(R.layout.alert_please_wait, null, false)
            builder.setView(customLayout)
            if (::dialog.isInitialized)
                if (dialog.isShowing)
                    dialog.dismiss()
            dialog = builder.create()
            dialog.window?.setBackgroundDrawable(inset)
            dialog.setCanceledOnTouchOutside(false)
            if(!isFinishing)
                dialog.show()
        }catch (e:Exception) {
            e.printStackTrace()
        }
    }


    open fun dialogCancel() {
        try {
            if (::dialog.isInitialized && (dialog.isShowing)) {
                dialog.cancel()
            }
        } catch (e:Exception) {
            e.printStackTrace()
        }
    }

    override fun onDestroy() {
        try {
            if (::dialog.isInitialized && (dialog.isShowing)) {
                dialog.cancel()
            }
        }catch (e:Exception) {
            e.printStackTrace()
        }
        super.onDestroy()
    }
}