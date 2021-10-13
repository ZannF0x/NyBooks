package com.zannardyapps.nybooks.data

import com.zannardyapps.nybooks.data.response.BookBodyResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewYorkTimesService {
    /*
     */
    companion object {
        private const val GET_VALUE = "lists.json"

        //parameters
        private const val QUERY_API_KEY = "api-key"
        private const val QUERY_LIST = "list"

        //values default
        private const val VALUE_API_KEY = "UneQ1Ub8OSdpgSKddv5vYw3ZNvu3wYAQ"
        private const val VALUE_LIST = "hardcover-fiction"
    }

    @GET(GET_VALUE)
    fun getListBooks(

        @Query(QUERY_API_KEY) apiKey: String = VALUE_API_KEY,
        @Query(QUERY_LIST) list: String = VALUE_LIST

    ): Call<BookBodyResponse>

}