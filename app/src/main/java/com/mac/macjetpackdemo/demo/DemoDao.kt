package com.mac.macjetpackdemo.demo

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Query

@Dao
interface DemoDao {
    @Query("select * from DemoModel order by id")
    fun getAllData(): DataSource.Factory<Int, DemoModel>
}