package com.iamsdt.room.db

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Owner")
class User(
    @PrimaryKey
    val userId: Int,
    val name: String,
    val age: Int
)