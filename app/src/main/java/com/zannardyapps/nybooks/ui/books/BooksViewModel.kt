package com.zannardyapps.nybooks.ui.books

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.zannardyapps.nybooks.data.ApiService
import com.zannardyapps.nybooks.data.model.Book
import com.zannardyapps.nybooks.data.response.BookBodyResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BooksViewModel():ViewModel() {

    val booksLiveData: MutableLiveData<List<Book>> = MutableLiveData()

    fun getBooks(){
        ApiService.service.getListBooks().enqueue(object: Callback<BookBodyResponse>{

                override fun onResponse(
                    call: Call<BookBodyResponse>, response: Response<BookBodyResponse>) {

                    if (response.isSuccessful) {
                        val booksMutableList: MutableList<Book> = mutableListOf()

                        response.body()?.let { bookBodyResponse ->
                            for (result in bookBodyResponse.bookResultResponse){
                                val book = Book(
                                    title = result.bookDetails[0].title,
                                    author = result.bookDetails[0].author
                                )
                                booksMutableList.add(book)
                            }
                        }
                        booksLiveData.value = booksMutableList
                    }

                }

                override fun onFailure(call: Call<BookBodyResponse>, t: Throwable) {

                    TODO("Not yet implemented")

                }

        })
    }

}