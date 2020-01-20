package kistudio.com.uniper.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.paging.LivePagedListBuilder
import kistudio.com.uniper.R
import kistudio.com.uniper.databinding.ActivityMainBinding
import kistudio.com.uniper.view_model.MainActivityViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)
        viewModel.popularMoviesList.observe(this, Observer {
            Log.d("tag", "updated! ${it.size}")
            viewModel.moviesMainAdapter.submitList(it)
        })

        binding.viewModel = viewModel
    }
}
