package com.zannardyapps.nybooks.data.response

import com.google.gson.annotations.SerializedName
import com.zannardyapps.nybooks.data.model.Book

data class BooksDetailsResponse(
    @SerializedName(value = "author")
    val author: String,
    @SerializedName(value = "title")
    val title: String,
    @SerializedName(value = "description")
    val description: String
) {
    fun getBookModel() = Book(
        title = this.title,
        author = this.author,
        description = this.description
    )
}

