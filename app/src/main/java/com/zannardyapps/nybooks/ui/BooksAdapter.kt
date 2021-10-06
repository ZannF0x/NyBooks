package com.zannardyapps.nybooks.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.zannardyapps.nybooks.R
import com.zannardyapps.nybooks.data.model.Book

class BooksAdapter(
    private val booksList: List<Book>
):RecyclerView.Adapter<BooksAdapter.BooksViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BooksViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_book,parent,false)

        return BooksViewHolder(view)
    }

    override fun onBindViewHolder(holder: BooksViewHolder, position: Int) {
        holder.bindViews(booksList[position])
    }

    override fun getItemCount() = booksList.count()



    inner class BooksViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

        private var titleView: TextView = itemView.findViewById(R.id.titleItemBook)
        private var authorView: TextView = itemView.findViewById(R.id.authorItemBook)

        fun bindViews(book: Book){
            titleView.text = book.title
            authorView.text = book.author
        }
    }

}