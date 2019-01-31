package com.iamsdt.paging.network

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

class RetrofitClient {

    private val BASE_URL = "https://api.stackexchange.com/2.2/"

    private var mInstance: RetrofitClient? = null

    private val retrofit: Retrofit

    val api: Api
        get() = retrofit.create(Api::class.java)

    init {
        retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val insance: RetrofitClient
        @Synchronized get() {
            if (mInstance == null) {
                mInstance = RetrofitClient()
            }
            return mInstance!!
        }
}