package com.iamsdt.paging.db

import androidx.paging.DataSource
import androidx.room.*

@Dao
interface StackEntityDao {

    @Insert
    fun insert(data: StackEntity)

    @Insert
    fun insert(data: List<StackEntity>)

    @Update
    fun update(data: StackEntity)

    @Delete
    fun delete(data: StackEntity)

    @Query("Select * From Photos")
    fun getAllData(): DataSource.Factory<Int, StackEntity>

}