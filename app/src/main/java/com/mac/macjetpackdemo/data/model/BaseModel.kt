package com.mac.macjetpackdemo.data.model

data class BaseModel<T>(
    val charge: Boolean,
    val code: String,
    val msg: String,
    val result: T
)