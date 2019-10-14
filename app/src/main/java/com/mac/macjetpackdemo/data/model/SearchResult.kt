package com.mac.macjetpackdemo.data.model

data class SearchResult(
    val msg: String,
    val result: ResultX,
    val status: String
) {
    data class ResultX(
        val list: List<DetailResult.Result>,
        val num: String
    )
}