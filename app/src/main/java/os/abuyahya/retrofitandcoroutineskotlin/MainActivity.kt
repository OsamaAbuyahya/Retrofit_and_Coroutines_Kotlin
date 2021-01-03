package os.abuyahya.retrofitandcoroutineskotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import os.abuyahya.retrofitandcoroutineskotlin.adapter.MyAdapter
import os.abuyahya.retrofitandcoroutineskotlin.databinding.ActivityMainBinding
import os.abuyahya.retrofitandcoroutineskotlin.repository.Repository
import os.abuyahya.retrofitandcoroutineskotlin.viewmodel.MainViewModel
import os.abuyahya.retrofitandcoroutineskotlin.viewmodel.MainViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding

    private val myAdapter by lazy { MyAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        setupRecyclerView()

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this,viewModelFactory).get(MainViewModel::class.java)
        viewModel.getPostUserIdAndSort(2, "id", "desc")
        viewModel.mListResponse.observe(this, { response ->
            if (response.isSuccessful) {
                response.body()?.let { myAdapter.setData(it) }
            } else
                Toast.makeText(this, response.code(), Toast.LENGTH_SHORT).show()
        })


    }

    private fun setupRecyclerView(){
        binding.recyclerView.adapter = myAdapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

    }
}
