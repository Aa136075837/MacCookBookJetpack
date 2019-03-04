package com.cmft.macjetpackdemo.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cmft.macjetpackdemo.R
import com.cmft.macjetpackdemo.util.toast

class DetailActivity : AppCompatActivity() {

    companion object {
        const val DETAIL_CLASSID = "detail_classid_key"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val classid = intent.getStringExtra(DETAIL_CLASSID)
        toast(classid)
    }
}
