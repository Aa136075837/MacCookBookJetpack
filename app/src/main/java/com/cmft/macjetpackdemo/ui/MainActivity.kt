package com.cmft.macjetpackdemo.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cmft.macjetpackdemo.R
import com.cmft.macjetpackdemo.ui.search.SearchResultActivity
import com.cmft.macjetpackdemo.util.setFullScreen
import com.cmft.macjetpackdemo.util.toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setFullScreen()

        mSearch.setOnClickListener {
            val keyword = mMainEt.text.toString().trim()
            if (keyword.isEmpty()) {
                toast("搜索内容不能为空")
            } else {
                val intent = Intent(this, SearchResultActivity::class.java)
                intent.putExtra(SearchResultActivity.KEYWORD_KEY, keyword)
                startActivity(intent)
            }
        }
    }

}
