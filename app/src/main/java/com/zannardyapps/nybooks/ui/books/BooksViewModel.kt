package com.zannardyapps.nybooks.ui.books

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.zannardyapps.nybooks.data.model.Book

class BooksViewModel():ViewModel() {

    val booksLiveData: MutableLiveData<List<Book>> = MutableLiveData()

    fun getBooks(){
        booksLiveData.value = getFakeList()
    }

    // Dados Fakes apenas para TESTE!
    private fun getFakeList() = listOf<Book>(
        Book(
            title = "Os Segredos da Mente Milionária",
            author = "T. Harv Eker"
        ),
        Book(
            title = "A Cabana",
            author = "William P. Young"
        ),
        Book(
            title = "O Milagre da Manhã",
            author = "Hal Elrod"
        )
    )
}