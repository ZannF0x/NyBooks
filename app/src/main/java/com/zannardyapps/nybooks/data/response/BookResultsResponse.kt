package com.zannardyapps.nybooks.data.response

import com.google.gson.annotations.SerializedName

data class BookResultsResponse(
    @SerializedName(value = "book_details")
    val bookDetails: List<BooksDetailsResponse>
)
