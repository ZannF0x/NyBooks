package com.zannardyapps.nybooks.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiService {

    private const val baseUrl: String = "https://api.nytimes.com/svc/books/v3/"

    private fun initRetrofit() = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service: NewYorkTimesService
    = initRetrofit().create(NewYorkTimesService::class.java)

}