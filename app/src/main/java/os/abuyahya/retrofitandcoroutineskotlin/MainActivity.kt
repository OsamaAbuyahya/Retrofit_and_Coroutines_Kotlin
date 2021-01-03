package os.abuyahya.retrofitandcoroutineskotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import os.abuyahya.retrofitandcoroutineskotlin.databinding.ActivityMainBinding
import os.abuyahya.retrofitandcoroutineskotlin.repository.Repository
import os.abuyahya.retrofitandcoroutineskotlin.viewmodel.MainViewModel
import os.abuyahya.retrofitandcoroutineskotlin.viewmodel.MainViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this,viewModelFactory).get(MainViewModel::class.java)

        val options: HashMap<String, String> = HashMap()
        options["_sort"] = "id"
        options["_order"] = "desc"
        binding.button.setOnClickListener {

            val num = binding.edtNum.text.toString()
            viewModel.getPostUserIdAndSortUsingMap(num.toInt(), options)
            viewModel.mListResponse.observe(this, Observer { response ->
                if (response.isSuccessful) {

                    response.body()?.forEach {
                        Log.d("Response", it.id.toString())
                        Log.d("Response", it.userId.toString())
                        Log.d("Response", it.title)
                        Log.d("Response", it.body)
                        Log.d("Response", "------------------------------")
                    }
                }
                else
                    Toast.makeText(this, response.code().toString(), Toast.LENGTH_SHORT).show()

            })

        }
    }
}
