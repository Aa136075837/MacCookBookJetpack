package com.mac.macjetpackdemo.data.db

import androidx.room.*
import com.mac.macjetpackdemo.data.model.TypeResult

@Dao
interface TypeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTypeList(typeList: List<TypeResult.TypeList>)

    @Query("select * from category_list")
    fun queryTypeList(): List<TypeResult.TypeList>

    @Delete
    fun deleteTypeList(typeList: List<TypeResult.TypeList>)
}