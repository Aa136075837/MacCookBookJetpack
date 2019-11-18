package com.mac.macjetpackdemo.demo

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DemoModel(
    val name: String? = null,
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null
)