package com.mac.macjetpackdemo.data.model

data class TypeResult(
    val msg: String,
    val result: List<TypeList>,
    val status: String
)

data class TypeList(
    val classid: String,
    val list: List<Type>,
    val name: String,
    val parentid: String
)

data class Type(
    val classid: String,
    val name: String,
    val parentid: String
)