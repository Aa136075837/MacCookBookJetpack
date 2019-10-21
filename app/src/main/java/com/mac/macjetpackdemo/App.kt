package com.mac.macjetpackdemo

import android.app.Application
import com.mac.macjetpackdemo.util.ContextUtil
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import com.qmuiteam.qmui.arch.QMUISwipeBackActivityManager

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        ContextUtil.registerApp(this)
        Logger.addLogAdapter(AndroidLogAdapter())
        QMUISwipeBackActivityManager.init(this)
    }
}