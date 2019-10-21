package com.mac.macjetpackdemo.util

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context

class ContextUtil {
    companion object {
        @SuppressLint("StaticFieldLeak")
        private lateinit var context: Context

        fun registerApp(application: Application) {
            context = application.applicationContext
        }

        fun getAppContext() = context
    }
}