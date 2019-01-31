package com.iamsdt.paging

import com.iamsdt.paging.db.Photos
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RestInterface {
    @GET("/photos")
    fun getPhotos(): Call<List<Photos>>
}


object RestServices {

    private const val BASE_URL = "https://jsonplaceholder.typicode.com"

    fun instance(): RestInterface = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build().create(
            RestInterface::
            class.java
        )
}