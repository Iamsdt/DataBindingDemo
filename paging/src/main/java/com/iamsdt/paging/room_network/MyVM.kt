package com.iamsdt.paging.room_network

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.iamsdt.paging.db.StackEntity
import com.iamsdt.paging.db.StackEntityDao
import com.iamsdt.paging.network.Item
import com.iamsdt.paging.network.RetrofitClient
import com.iamsdt.paging.network.StackApiResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MyVM : ViewModel() {

    val first_key = 1
    var nextPage_key = 1

    val PAGE_SIZE = 50
    val SITE_NAME = "Stackoverflow"

    fun data(dao: StackEntityDao): LiveData<PagedList<StackEntity>> {

        val factory = dao.getAllData()

        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setPageSize(50)
            .build()

        val boundary = getBoundary(dao)

        return LivePagedListBuilder<Int, StackEntity>(factory, config)
            .setBoundaryCallback(boundary)
            .build()
    }


    private fun getBoundary(dao: StackEntityDao) = object : PagedList.BoundaryCallback<StackEntity>() {
        override fun onZeroItemsLoaded() {
            super.onZeroItemsLoaded()
            call(first_key, dao)
        }

        override fun onItemAtEndLoaded(itemAtEnd: StackEntity) {
            super.onItemAtEndLoaded(itemAtEnd)
            //last item load
            //call for new data
            call(nextPage_key, dao)
        }
    }

    private fun call(key: Int, dao: StackEntityDao) {

        RetrofitClient.instance()
            .getAnswers(key, PAGE_SIZE, SITE_NAME)
            .enqueue(object : Callback<StackApiResponse> {
                override fun onResponse(
                    call: Call<StackApiResponse>,
                    response: Response<StackApiResponse>
                ) {
                    if (response.body() != null) {
                        //save nex key
                        val api = response.body()
                        if (api?.has_more == true && nextPage_key < PAGE_SIZE) {
                            nextPage_key++
                        }

                        val list = api?.items ?: emptyList()
                        list.forEach {
                            dao.insert(it.toStackEntity())
                        }
                    }

                }

                override fun onFailure(call: Call<StackApiResponse>, t: Throwable) {
                    //nothing to do
                }
            })
    }

    private fun Item.toStackEntity() = StackEntity(
        name = owner?.display_name ?: "no name found",
        img = owner?.profile_image ?: "no link"
    )
}