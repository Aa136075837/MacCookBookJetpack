package com.mac.macjetpackdemo.data.model

import androidx.room.Entity

@Entity(tableName = "category_list")
data class TypeResult(
    var msg: String? = null,
    var result: List<TypeList>? = null,
    var status: String? = null
) {
    data class TypeList(
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