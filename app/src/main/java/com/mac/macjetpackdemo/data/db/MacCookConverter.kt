package com.mac.macjetpackdemo.data.db

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.mac.macjetpackdemo.data.model.DetailResult
import com.mac.macjetpackdemo.data.model.TypeResult

class MacCookConverter {
    @TypeConverter
    fun detailListToString(list: List<DetailResult.Result>): String {
        return Gson().toJson(list)
    }

    @TypeConverter
    fun stringToDetailList(s: String): List<DetailResult.Result> {
        return Gson().fromJson(s, object : TypeToken<List<DetailResult.Result>>() {}.type)
    }

    @TypeConverter
    fun typeListToString(result: List<TypeResult.TypeList>): String {
        return Gson().toJson(result)
    }

    @TypeConverter
    fun stringToTypeList(s: String): List<TypeResult.TypeList> {
        return Gson().fromJson(s, object : TypeToken<List<TypeResult.TypeList>>() {}.type)
    }

    @TypeConverter
    fun typeToString(result: List<TypeResult.TypeList.Type>): String {
        return Gson().toJson(result)
    }

    @TypeConverter
    fun stringToType(s: String): List<TypeResult.TypeList.Type> {
        return Gson().fromJson(s, object : TypeToken<List<TypeResult.TypeList.Type>>() {}.type)
    }
}