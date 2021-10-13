package com.zannardyapps.nybooks.data.response

import com.google.gson.annotations.SerializedName

data class BooksDetailsResponse(
    @SerializedName(value = "author")
    val author: String,
    @SerializedName(value = "title")
    val title: String,
    @SerializedName(value = "description")
    val description: String
)
