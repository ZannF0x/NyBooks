package com.zannardyapps.nybooks.data.response

import com.google.gson.annotations.SerializedName

data class BookBodyResponse(
    @SerializedName(value = "results")
    val bookResultResponse: List<BookResultsResponse>
)
