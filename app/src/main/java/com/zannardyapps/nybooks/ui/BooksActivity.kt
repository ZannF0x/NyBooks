package com.zannardyapps.nybooks.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.zannardyapps.nybooks.R
import com.zannardyapps.nybooks.data.model.Book
import com.zannardyapps.nybooks.databinding.ActivityBooksBinding

class BooksActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBooksBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBooksBinding.inflate(layoutInflater)
        setContentView(binding.root)

        toolbarSettings()
        initAdapter()

    }

    private fun toolbarSettings(){
        val toolbarBooksActivity = binding.toolbarBooksActivity
        toolbarBooksActivity.title = getString(R.string.books_toolbar_title)
        setSupportActionBar(toolbarBooksActivity)
    }

    private fun initAdapter(){
        binding.recyclerViewBooksActivity.apply {

            layoutManager = LinearLayoutManager(
                this@BooksActivity,
                RecyclerView.VERTICAL,
                false)

            setHasFixedSize(true)

            adapter = BooksAdapter(getList())

        }
    }

    // Dados Mocados para TESTE!
    private fun getList() = listOf<Book>(
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