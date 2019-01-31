package com.iamsdt.paging.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Photos(
    @SerializedName("albumId")
    val albumId: Int = 0,
    @SerializedName("id")
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @SerializedName("title")
    val title: String = "",
    @SerializedName("url")
    val url: String = "",
    @SerializedName("thumbnailUrl")
    val thumbnailUrl: String = ""
)