package com.iamsdt.paging.network

import androidx.paging.PageKeyedDataSource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NetworkDataSource : PageKeyedDataSource<Int, Item>() {

    val PAGE_SIZE = 50
    val FIRST_PAGE = 1
    val SITE_NAME = "Stackoverflow"


    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, Item>) {
        RetrofitClient.instance()
            .getAnswers(FIRST_PAGE, PAGE_SIZE, SITE_NAME)
            .enqueue(object : Callback<StackApiResponse> {
                override fun onResponse(
                    call: Call<StackApiResponse>,
                    response: Response<StackApiResponse>
                ) {

                    if (response.body() != null) {

                        val list = response.body()?.items ?: emptyList()
                        callback.onResult(list, null, FIRST_PAGE + 1)

                    }

                }

                override fun onFailure(call: Call<StackApiResponse>, t: Throwable) {
                    //nothing to do
                }
            })
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Item>) {
        RetrofitClient.instance()
            .getAnswers(params.key, PAGE_SIZE, SITE_NAME)
            .enqueue(object : Callback<StackApiResponse> {
                override fun onResponse(
                    call: Call<StackApiResponse>,
                    response: Response<StackApiResponse>
                ) {

                    response.body()?.let {
                        val key: Int? = if (it.has_more) params.key + 1
                        else null

                        val list = response.body()?.items ?: emptyList()
                        callback.onResult(list, key)
                    }

                }

                override fun onFailure(call: Call<StackApiResponse>, t: Throwable) {
                    //nothing to do
                }
            })
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Item>) {
        RetrofitClient.instance()
            .getAnswers(params.key, PAGE_SIZE, SITE_NAME)
            .enqueue(object : Callback<StackApiResponse> {
                override fun onResponse(
                    call: Call<StackApiResponse>,
                    response: Response<StackApiResponse>
                ) {

                    val key: Int? = if (params.key > 1) params.key - 1 else null

                    if (response.body() != null) {
                        val list = response.body()?.items ?: emptyList()
                        callback.onResult(list, key)
                    }

                }

                override fun onFailure(call: Call<StackApiResponse>, t: Throwable) {
                    //nothing to do
                }
            })
    }

}