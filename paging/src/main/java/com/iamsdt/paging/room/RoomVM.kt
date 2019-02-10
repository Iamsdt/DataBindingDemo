package com.iamsdt.paging.room

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.iamsdt.paging.db.Photos
import com.iamsdt.paging.db.PhotosDao

class RoomVM : ViewModel() {

    fun getData(dao: PhotosDao) = dao.data

    fun data(dao: PhotosDao): LiveData<PagedList<Photos>> {
        val factory = dao.getAllData()

        val config = PagedList.Config.Builder()
            .setPageSize(30)
            .setInitialLoadSizeHint(50)
            .setPrefetchDistance(20)
            .setEnablePlaceholders(false)
            .build()

        return LivePagedListBuilder<Int, Photos>(factory, config)
            .build()
    }
}