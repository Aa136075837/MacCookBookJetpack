package com.mac.macjetpackdemo.util

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.util.TypedValue
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.qmuiteam.qmui.widget.QMUIEmptyView

fun Fragment.toast(msg: String?) = Toast.makeText(activity, msg, Toast.LENGTH_SHORT).show()

fun Context.toast(msg: String?) = Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()

fun Context.toast(resId: Int) = Toast.makeText(this, resId, Toast.LENGTH_SHORT).show()

fun Fragment.toActivityNotFinish(cls: Class<*>) {
    activity?.let {
        val intent = Intent(it, cls)
        it.startActivity(intent)
    }
}

fun Activity.toActivityNotFinish(cls: Class<*>) {
    val intent = Intent(this, cls)
    startActivity(intent)
}

/**
 * 设置页面为全屏
 */
fun Activity.setFullScreen() {
    if (Build.VERSION.SDK_INT > 21) {
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
        window.statusBarColor = Color.TRANSPARENT
    } else {
        window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
    }
}

/**
 * 设置状态栏颜色
 */
fun Activity.setStatusBarColor(colorRes: Int) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        window.statusBarColor = resources.getColor(colorRes)
    }
}

fun Fragment.setStatusBarColor(colorRes: Int) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        activity!!.window.statusBarColor = resources.getColor(colorRes)
    }
}

fun Fragment.toActivityFinish(cls: Class<*>) {
    activity?.let {
        val intent = Intent(it, cls)
        it.startActivity(intent)
        it.finish()
    }
}

fun Activity.toActivityFinish(cls: Class<*>) {
    val intent = Intent(this, cls)
    startActivity(intent)
    finish()
}

fun Fragment.toActivityNotFinish(intent: Intent) {
    activity?.startActivity(intent)
}

fun Activity.toActivityNotFinish(intent: Intent) {
    startActivity(intent)
}

fun Fragment.toActivityFinish(intent: Intent) {
    activity?.startActivity(intent)
    activity?.finish()
}

fun Activity.toActivityFinish(intent: Intent) {
    startActivity(intent)
    finish()
}

fun Fragment.toActivityForResult(cls: Class<*>, requestCode: Int) {
    activity?.let {
        val intent = Intent(it, cls)
        it.startActivityForResult(intent, requestCode)
        it.finish()
    }
}

fun Activity.toActivityForResult(cls: Class<*>, requestCode: Int) {
    val intent = Intent(this, cls)
    startActivityForResult(intent, requestCode)
    finish()
}

fun Fragment.toActivityForResult(intent: Intent, requestCode: Int) {
    activity?.startActivityForResult(intent, requestCode)
    activity?.finish()
}

fun Activity.toActivityForResult(intent: Intent, requestCode: Int) {
    startActivityForResult(intent, requestCode)
    finish()
}


fun Context.dip2Px(dip: Int): Int {
    val density = resources.getDisplayMetrics().density
    return (dip.toFloat() * density + 0.5f).toInt()
}

fun Context.px2dip(px: Int): Int {
    val density = resources.getDisplayMetrics().density
    return (px.toFloat() / density + 0.5f).toInt()
}

fun Context.sp2px(sp: Int): Int {
    return (TypedValue.applyDimension(2, sp.toFloat(), resources.getDisplayMetrics()) + 0.5f).toInt()
}

fun QMUIEmptyView.show(boolean: Boolean, title: String) {
    show(boolean, title, null, null, null)
}