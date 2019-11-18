package com.mac.macjetpackdemo.demo

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.mac.macjetpackdemo.data.db.MacCookDatabase

class DemoViewModel(app: Application) : AndroidViewModel(app) {

    private val dao = MacCookDatabase.getInstance(app).getDemoDao()

    fun getFreshListData(): LiveData<PagedList<DemoModel>> =
        LivePagedListBuilder(
            dao.getAllData(), PagedList.Config.Builder()
                .setPageSize(15)
                .setEnablePlaceholders(false)     //配置是否启动PlaceHolders
                .setInitialLoadSizeHint(15)
                .build()
        ).build()
}