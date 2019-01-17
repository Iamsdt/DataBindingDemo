package com.iamsdt.room.db

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "pets",
    foreignKeys = [ForeignKey(
        entity = User::class,
        parentColumns = arrayOf("userId"),
        childColumns = arrayOf("owner")
    )]
)
data class Pet(@PrimaryKey val petId: String,
               val name: String,
               val owner: String)