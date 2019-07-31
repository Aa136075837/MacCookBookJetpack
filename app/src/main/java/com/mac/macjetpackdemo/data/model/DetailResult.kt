package com.mac.macjetpackdemo.data.model

data class DetailResult(
    val msg: String,
    val result: Result,
    val status: String
){
    data class Result(
        val classid: String,
        val content: String,
        val cookingtime: String,
        val id: String,
        val material: List<Material>,
        val name: String,
        val peoplenum: String,
        val pic: String,
        val preparetime: String,
        val process: List<Proces>,
        val tag: String
    )
}