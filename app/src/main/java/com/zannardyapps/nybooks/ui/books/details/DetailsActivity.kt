package com.zannardyapps.nybooks.ui.books.details

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.zannardyapps.nybooks.R
import com.zannardyapps.nybooks.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        toolbarSettings()

        val title = intent.getStringExtra(EXTRA_TITLE)
        val description = intent.getStringExtra(EXTRA_DESCRIPTION)

        binding.detailsTitle.text = title
        binding.detailsDescription.text = description
    }



    private fun toolbarSettings(){
        val toolbarDetailsActivity = binding.toolbarDetailsActivity
        toolbarDetailsActivity.title = getString(R.string.details_toolbar_title)
        setSupportActionBar(toolbarDetailsActivity)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    companion object {

        private const val EXTRA_TITLE = "EXTRA_TITLE"
        private const val EXTRA_DESCRIPTION = "EXTRA_DESCRIPTION"

        fun getStartIntent(
            context: Context,
            title: String,
            description: String): Intent{

            return Intent(context, DetailsActivity::class.java).apply {
                putExtra(EXTRA_TITLE, title)
                putExtra(EXTRA_DESCRIPTION, description)
            }
        }
    }

}