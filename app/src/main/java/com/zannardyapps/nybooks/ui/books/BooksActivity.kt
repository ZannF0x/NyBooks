package com.zannardyapps.nybooks.ui.books

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.zannardyapps.nybooks.R
import com.zannardyapps.nybooks.data.model.Book
import com.zannardyapps.nybooks.databinding.ActivityBooksBinding
import com.zannardyapps.nybooks.ui.books.details.DetailsActivity

class BooksActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBooksBinding

    private val booksViewModel: BooksViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBooksBinding.inflate(layoutInflater)
        setContentView(binding.root)

        toolbarSettings()

        // ViewModel:
        booksViewModel.booksLiveData.observe(this, Observer { list ->

            list?.let { books ->
                initAdapter(books)
            }

        })

        booksViewModel.viewFlipperLiveData.observe(this, Observer {
            it?.let { viewFlipper ->

                binding.viewFlipperBooks.displayedChild = viewFlipper.first

                viewFlipper.second?.let { errorMessageId ->

                    binding.textErroType.text = getString(errorMessageId)

                }
            }
        })

        booksViewModel.getBooks()
    }

    private fun toolbarSettings(){
        val toolbarBooksActivity = binding.toolbarBooksActivity
        toolbarBooksActivity.title = getString(R.string.books_toolbar_title)
        setSupportActionBar(toolbarBooksActivity)
    }

    private fun initAdapter(listBook: List<Book>){

        binding.recyclerViewBooksActivity.apply {

            layoutManager = LinearLayoutManager(
                this@BooksActivity,
                RecyclerView.VERTICAL,
                false)

            setHasFixedSize(true)

            adapter = BooksAdapter(listBook){ book: Book ->

               val intent = DetailsActivity.getStartIntent(
                    this@BooksActivity,
                    book.title,
                    book.description
               )

                this@BooksActivity.startActivity(intent)
            }
        }

    }

}