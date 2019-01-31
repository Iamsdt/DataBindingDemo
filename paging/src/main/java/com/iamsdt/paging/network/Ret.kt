package com.iamsdt.paging.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    @GET("answers")
    fun getAnswers(
        @Query("page") page: Int,
        @Query("pagesize") size: Int,
        @Query("site") site: String
    ): Call<StackApiResponse>
}

object RetrofitClient {

    private val BASE_URL = "https://api.stackexchange.com/2.2/"

    fun instance(): Api = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build().create(
            Api::
            class.java
        )
}