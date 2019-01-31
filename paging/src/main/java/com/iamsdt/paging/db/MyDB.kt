package com.iamsdt.paging.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Photos::class, StackEntity::class], version = 1, exportSchema = false)
abstract class MyDatabase : RoomDatabase() {
    abstract val photosDao: PhotosDao
    abstract val stackEntityDao: StackEntityDao
}

object MyDB {

    lateinit var instance: MyDatabase

    private fun getDatabase(context: Context): MyDatabase =
        if (!::instance.isInitialized) {
            Room.databaseBuilder(
                context,
                MyDatabase::class.java, "MyDB"
            ).build()
        } else instance

    fun getDao(context: Context) = getDatabase(context).photosDao
    fun getStackDao(context: Context) = getDatabase(context).stackEntityDao
}