package com.mac.macjetpackdemo.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [MacCookConverter::class], version = 1)
@TypeConverters(MacCookConverter::class)
abstract class MacCookDatabase : RoomDatabase() {

    abstract fun getTypeDao(): TypeDao
}