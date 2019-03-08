package com.cmft.macjetpackdemo.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.cmft.macjetpackdemo.R
import com.cmft.macjetpackdemo.net.Status
import com.cmft.macjetpackdemo.util.InjectUtil
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    companion object {
        const val DETAIL_CLASSID = "detail_classid_key"
        const val DETAIL_NAME = "detail_name_key"
    }

    private var detailModel: DetailModel? = null
    private lateinit var detailAdapter: DetailAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val id = intent.getStringExtra(DETAIL_CLASSID)
        val name = intent.getStringExtra(DETAIL_NAME)
        detailModel = ViewModelProviders.of(this, InjectUtil.getDetailModelFactory()).get(DetailModel::class.java)
        initToolbar(name)
        detailAdapter = DetailAdapter()
        mDetailRv.adapter = detailAdapter
        initData(id)
    }

    private fun initToolbar(name: String) {
        mDetailToolbar.title = name
        mDetailToolbar.navigationIcon
    }

    private fun initData(id: String) {
        val liveData = detailModel?.getDetailById(id)
        liveData?.observe(this, Observer {
            if (it.status == Status.SUCCESS) {
                it.data?.result?.run {
                    if (!process.isNullOrEmpty()) {
                        detailAdapter.setData(it.data.result)
                    }
                }
            }
        })
    }
}
