package com.iamsdt.paging.network

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.iamsdt.paging.db.StackEntity

class NetworkViewModel : ViewModel() {

    val data: LiveData<PagedList<StackEntity>>
        get() {
            val factory = NetworkDataSourceFactory()

            val config = PagedList.Config.Builder()
                .setEnablePlaceholders(false)
                .setPageSize(50)
                .build()

            return LivePagedListBuilder<Int, StackEntity>(factory, config).build()
        }

}