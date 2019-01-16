package com.iamsdt.room.db

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
class MyData(
    val name: String,
    @PrimaryKey
    val userID: Int
)