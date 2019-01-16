package com.iamsdt.room.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update

@Dao
interface BaseDao<T> {


    //Insert Operation
    @Insert
    fun insert(data: T): Long

    @Insert
    fun insert(vararg data: T): Long

    @Insert
    fun insert(data: List<T>): Long


    //update
    @Update
    fun update(data: T): Int

    @Delete
    fun delete(data: T): Int


}