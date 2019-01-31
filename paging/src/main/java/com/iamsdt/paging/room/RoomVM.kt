package com.iamsdt.paging.room

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.iamsdt.paging.db.Photos
import com.iamsdt.paging.db.PhotosDao

class RoomVM : ViewModel() {

    fun data(dao: PhotosDao): LiveData<PagedList<Photos>> {
        val factory = dao.getAllData()

        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setPageSize(50)
            .build()

        return LivePagedListBuilder<Int, Photos>(factory, config)
            .build()
    }
}