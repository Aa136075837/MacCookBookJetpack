package com.mac.macjetpackdemo.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

data class TypeResult(
    var msg: String? = null,
    var result: List<TypeList>? = null,
    var status: String? = null
) {
    @Entity(tableName = "category_list")
    data class TypeList(
        @PrimaryKey(autoGenerate = true)
        var id: Int = 0,
        var classid: String? = null,
        var list: List<Type>? = null,
        var name: String? = null,
        var parentid: String? = null
    ) {
        data class Type(
            var classid: String? = null,
            var name: String? = null,
            var parentid: String? = null
        )
    }
}