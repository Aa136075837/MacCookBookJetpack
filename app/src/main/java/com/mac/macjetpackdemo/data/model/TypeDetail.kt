package com.mac.macjetpackdemo.data.model

data class TypeDetail(
    val msg: String,
    val result: Result,
    val status: String
)

data class Result(
    val list: List<DetailResult.Result>,
    val num: String
)

