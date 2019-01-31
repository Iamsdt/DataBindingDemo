package com.iamsdt.paging.network

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList

class NetworkViewModel : ViewModel() {

    val data: LiveData<PagedList<Item>>
        get() {
            val factory = NetworkDataSourceFactory()

            val config = PagedList.Config.Builder()
                .setEnablePlaceholders(false)
                .setPageSize(50)
                .build()

            return LivePagedListBuilder<Int, Item>(factory, config).build()
        }

}