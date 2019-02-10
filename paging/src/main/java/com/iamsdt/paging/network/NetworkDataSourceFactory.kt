package com.iamsdt.paging.network

import androidx.paging.DataSource
import com.iamsdt.paging.db.StackEntity

class NetworkDataSourceFactory : DataSource.Factory<Int, StackEntity>() {
    override fun create(): DataSource<Int, StackEntity> = NetworkDataSource()
}