package com.zannardyapps.nybooks.ui.books

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.zannardyapps.nybooks.R
import com.zannardyapps.nybooks.data.ApiService
import com.zannardyapps.nybooks.data.model.Book
import com.zannardyapps.nybooks.data.response.BookBodyResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BooksViewModel():ViewModel() {

    val booksLiveData: MutableLiveData<List<Book>> = MutableLiveData()
    val viewFlipperLiveData: MutableLiveData<Pair<Int, Int?>> = MutableLiveData()

    fun getBooks(){
        ApiService.service.getListBooks().enqueue(object: Callback<BookBodyResponse>{

                override fun onResponse(
                    call: Call<BookBodyResponse>, response: Response<BookBodyResponse>) {

                    if (response.isSuccessful) {
                        val booksMutableList: MutableList<Book> = mutableListOf()

                        response.body()?.let { bookBodyResponse ->
                            for (result in bookBodyResponse.bookResultResponse){
                                val book = result.bookDetails[0].getBookModel()
                                booksMutableList.add(book)
                            }
                        }
                        booksLiveData.value = booksMutableList
                        viewFlipperLiveData.value = Pair(VIEW_FLIPPER_BOOKS, null)

                        //ERRO TYPE
                    } else if (response.code() == 401) {
                        viewFlipperLiveData.value = Pair(VIEW_FLIPPER_ERROR, R.string.erro_401)
                    } else {
                        viewFlipperLiveData.value = Pair(VIEW_FLIPPER_ERROR, R.string.erro_400_generic)
                    }

                }

                override fun onFailure(call: Call<BookBodyResponse>, t: Throwable) {
                    viewFlipperLiveData.value = Pair(VIEW_FLIPPER_ERROR, R.string.erro_500_generic)
                }

        })
    }

    companion object {
        private const val VIEW_FLIPPER_BOOKS = 1
        private const val VIEW_FLIPPER_ERROR = 2
    }

}