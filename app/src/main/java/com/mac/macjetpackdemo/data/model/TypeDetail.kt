package com.mac.macjetpackdemo.data.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "category")
data class TypeDetail(
    @PrimaryKey(autoGenerate = true)
    var id: Long,
    var msg: String? = null,
    @Embedded(prefix = "group_")
    var result: Result? = null,
    var status: String? = null
)

data class Result(
    var list: List<DetailResult.Result>? = null,
    var num: String? = null
)

