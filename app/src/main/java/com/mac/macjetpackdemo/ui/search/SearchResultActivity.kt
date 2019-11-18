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
import kotlinx.android.synthetic.main.activity_search_result.*

class SearchResultActivity : BaseActivity() {

    lateinit var viewModel: SearchModel
    private lateinit var searchResultAdapter: SearchResultAdapter

    companion object {
        const val KEYWORD_KEY = "search_key_word"
        const val CLASS_ID_KEY = "class_id_key"
        const val LOAD_TYPE_LEY = "load_type_ley"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_result)

        viewModel = ViewModelProviders.of(this, InjectUtil.getSearchModelFactory())
            .get(SearchModel::class.java)
        mSearchToolbar.title = intent.getStringExtra(KEYWORD_KEY)
        initAdapter()
        val loadType = intent.getIntExtra(LOAD_TYPE_LEY, 0)
        when (loadType) {
            0 -> initData()
            1 -> initDataByClassId()
        }
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
        mSearchEmpty.show(true, "正在加载...", null, null, null)

        val liveData = viewModel.getSearchDetail(intent.getStringExtra(KEYWORD_KEY))

        liveData.observe(this, Observer {
            if (it.status == Status.SUCCESS) {
                it.data?.run {
                    mSearchEmpty.visibility = View.GONE
                    searchResultAdapter.setData(result.list)
                }
            } else if (it.status == Status.ERROR) {
                mSearchEmpty.show(false, "无该菜品信息", null, null, null)
            }
        })
    }

    private fun initDataByClassId() {
        mSearchEmpty.show(true, "正在加载...", null, null, null)
        val liveData = viewModel.getListByClassId(intent.getStringExtra(CLASS_ID_KEY), "0", "30")
        liveData.observe(this, Observer {
            if (it.status == Status.SUCCESS) {
                it.data?.run {
                    mSearchEmpty.visibility = View.GONE
                    searchResultAdapter.setData(result?.list!!)
                }
            } else if (it.status == Status.ERROR) {
                mSearchEmpty.show(false, "无该品类信息", null, null, null)
            }
        })
    }
}
