package com.zannardyapps.nybooks.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.zannardyapps.nybooks.R
import com.zannardyapps.nybooks.databinding.ActivityBooksBinding

class BooksActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBooksBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBooksBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}