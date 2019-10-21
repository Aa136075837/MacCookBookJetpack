package com.mac.macjetpackdemo.ui.type

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.mac.macjetpackdemo.R
import com.mac.macjetpackdemo.base.BaseActivity
import com.mac.macjetpackdemo.data.model.Result
import com.mac.macjetpackdemo.data.model.TypeResult
import com.mac.macjetpackdemo.net.Status
import com.mac.macjetpackdemo.util.InjectUtil
import com.mac.macjetpackdemo.util.toast
import kotlinx.android.synthetic.main.activity_search_result.*
import kotlinx.android.synthetic.main.activity_type.*

class TypeActivity : BaseActivity() {
    private var typeModel: TypeModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_type)
        typeModel = ViewModelProviders.of(this, InjectUtil.getTypeModelFactor()).get(TypeModel::class.java)
        mTypeToolbar.title = "分类"
        initData()
    }

    private fun initData() {
        mTypeEmpty.show(true, "正在加载...", null, null, null)
        val liveData = typeModel?.getType()
        liveData?.observe(this, Observer {
            mTypeEmpty.visibility = View.GONE
            if (it.status == Status.SUCCESS) {
                initAdapter(it.data!!)
            } else if (it.status == Status.ERROR) {
                toast(it.message)
            }
        })
    }

    private fun initAdapter(data: List<TypeResult.TypeList>) {
        val adapter = ExListAdapter(data)
        mExListView.setAdapter(adapter)
    }
}
