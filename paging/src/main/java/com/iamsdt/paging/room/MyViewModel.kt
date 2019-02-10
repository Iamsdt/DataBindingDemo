package com.iamsdt.paging.room

import androidx.lifecycle.ViewModel
import com.iamsdt.paging.db.PhotosDao

class MyViewModel : ViewModel() {
    fun getData(dao: PhotosDao) = dao.data
}
