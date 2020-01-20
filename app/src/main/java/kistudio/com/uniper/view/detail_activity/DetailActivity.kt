package kistudio.com.uniper.view.detail_activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import kistudio.com.uniper.R
import kistudio.com.uniper.databinding.ActivityDetailBinding
import kistudio.com.uniper.model.entities.Movie
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityDetailBinding
    private lateinit var mViewModel: DetailActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_detail)
        mViewModel = ViewModelProviders.of(this).get(DetailActivityViewModel::class.java)
        mBinding.viewModel = mViewModel

        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        mViewModel.setMovie(intent.getParcelableExtra<Movie>(EXTRA_MOVIE))
    }

    companion object{
        private const val EXTRA_MOVIE = "movie"

        fun launch(context: Context, movie:Movie){
            val intent = Intent(context,
                DetailActivity::class.java)
            intent.putExtra(EXTRA_MOVIE,movie)
            context.startActivity(intent)
        }
    }
}
