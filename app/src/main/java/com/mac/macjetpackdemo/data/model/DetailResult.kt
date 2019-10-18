package com.mac.macjetpackdemo.data.model

data class DetailResult(
    val msg: String,
    val result: Result,
    val status: String
) {
    data class Result(
        var classid: String? = null,
        var content: String? = null,
        var cookingtime: String? = null,
        var id: String? = null,
        var material: List<Material>? = null,
        var name: String? = null,
        var peoplenum: String? = null,
        var pic: String? = null,
        var preparetime: String? = null,
        var process: List<Proces>? = null,
        var tag: String? = null
    )
}