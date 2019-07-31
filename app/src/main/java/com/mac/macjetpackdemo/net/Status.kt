package com.mac.macjetpackdemo.net

data class Status<T>(val status: Int, val data: T?, val message: String?) {

    companion object {
        const val SUCCESS = 0
        const val ERROR = 1
        const val LOADING = 2

        fun <T> success(data: T?) = Status(SUCCESS, data, null)

        fun <T> error(msg: String, data: T?) = Status(ERROR, data, msg)

        fun <T> loading(data: T?) = Status(LOADING, data, null)
    }
}
