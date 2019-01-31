package com.iamsdt.paging.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class StackEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var name: String = "",
    var img: String = ""
)