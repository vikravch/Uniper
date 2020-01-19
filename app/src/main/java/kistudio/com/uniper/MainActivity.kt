package kistudio.com.uniper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kistudio.com.uniper.view_model.MainActivityViewModel

class MainActivity : AppCompatActivity() {
    
    //private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
