package com.iamsdt.paging.db

import androidx.paging.DataSource
import androidx.room.*


@Dao
interface PhotosDao {

    @Insert
    fun insert(data: Photos)

    @Insert
    fun insert(data: List<Photos>)

    @Update
    fun update(data: Photos)

    @Delete
    fun delete(data: Photos)

    @Query("Select * From Photos")
    fun getAllData(): DataSource.Factory<Int, Photos>

}