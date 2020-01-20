package kistudio.com.uniper.view.main_activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kistudio.com.uniper.R
import kistudio.com.uniper.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding
    private lateinit var mViewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mViewModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)
        mViewModel.popularMoviesList.observe(this, Observer {
            Log.d("tag", "updated! ${it.size}")
            mViewModel.moviesMainAdapter.submitList(it)
        })
        mBinding.viewModel = mViewModel
    }
}