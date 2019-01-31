package com.iamsdt.paging.network

import androidx.paging.DataSource

class NetworkDataSourceFactory : DataSource.Factory<Int, Item>() {
    override fun create(): DataSource<Int, Item> = NetworkDataSource()
}