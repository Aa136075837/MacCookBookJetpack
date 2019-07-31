package com.mac.macjetpackdemo.ui.search

import android.graphics.Rect
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.mac.macjetpackdemo.R
import com.mac.macjetpackdemo.base.BaseActivity
import com.mac.macjetpackdemo.net.Status
import com.mac.macjetpackdemo.util.InjectUtil
import com.mac.macjetpackdemo.util.toast
import kotlinx.android.synthetic.main.activity_search_result.*

class SearchResultActivity : BaseActivity() {

    lateinit var viewModel: SearchModel
    private lateinit var searchResultAdapter: SearchResultAdapter

    companion object {
        const val KEYWORD_KEY = "search_key_word"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_result)

        viewModel = ViewModelProviders.of(this, InjectUtil.getSearchModelFactory())
            .get(SearchModel::class.java)
        mSearchToolbar.title = intent.getStringExtra(KEYWORD_KEY)
        initAdapter()
        initData()
    }

    private fun initAdapter() {
        searchResultAdapter = SearchResultAdapter()
        mSearchResultRv.adapter = searchResultAdapter
        mSearchResultRv.addItemDecoration(object : RecyclerView.ItemDecoration() {
            override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
                super.getItemOffsets(outRect, view, parent, state)
                outRect.set(5, 5, 5, 15)
            }
        })
    }

    private fun initData() {
        val liveData = viewModel.getSearchDetail(intent.getStringExtra(KEYWORD_KEY))

        liveData.observe(this, Observer {
            if (it.status == Status.SUCCESS) {
                it.data?.run {
                    searchResultAdapter.setData(result.list)
                }
            } else if (it.status == Status.ERROR) {
                toast(it.message)
            }
        })
    }
}
