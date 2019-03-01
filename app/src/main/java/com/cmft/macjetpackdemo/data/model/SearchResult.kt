package com.cmft.macjetpackdemo.data.model

data class SearchResult(
    val msg: String,
    val result: ResultX,
    val status: String
) {
    data class ResultX(
        val list: List<X>,
        val num: String
    ) {
        data class X(
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
}