package com.iamsdt.paging.db

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*


@Dao
interface PhotosDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(data: Photos)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(data: List<Photos>)

    @Update
    fun update(data: Photos)

    @Delete
    fun delete(data: Photos)

    @Query("Select * From Photos")
    fun getAllData(): DataSource.Factory<Int, Photos>

    @get:Query("Select * From Photos")
    val data: DataSource.Factory<Int, Photos>

}