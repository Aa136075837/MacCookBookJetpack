package com.mac.macjetpackdemo.data.db

import android.app.Application
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.mac.macjetpackdemo.data.model.TypeResult
import com.mac.macjetpackdemo.demo.DemoDao
import com.mac.macjetpackdemo.demo.DemoModel

@Database(entities = [TypeResult.TypeList::class], version = 1)
@TypeConverters(MacCookConverter::class, DemoModel::class)
abstract class MacCookDatabase : RoomDatabase() {

    abstract fun getTypeDao(): TypeDao

    abstract fun getDemoDao(): DemoDao

    companion object {
        @Volatile
        private var instance: MacCookDatabase? = null

        fun getInstance(context: Context) = instance ?: synchronized(this) {
            instance ?: buildDatabase(context).also { instance = it }
        }

        private
        fun buildDatabase(context: Context): MacCookDatabase {
            val appContext: Context = if (context is Application) {
                context
            } else {
                context.applicationContext
            }

            return Room.databaseBuilder(appContext, MacCookDatabase::class.java, "MAC_Cook")
                .fallbackToDestructiveMigration()
//            .addMigrations()
                .build()
        }
    }
}