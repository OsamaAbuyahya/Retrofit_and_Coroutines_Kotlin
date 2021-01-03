package os.abuyahya.retrofitandcoroutineskotlin.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import os.abuyahya.retrofitandcoroutineskotlin.model.Post
import os.abuyahya.retrofitandcoroutineskotlin.repository.Repository
import retrofit2.Response

class MainViewModel(private val repository: Repository): ViewModel() {

    val mResponse: MutableLiveData<Response<Post>> = MutableLiveData()
    val mListResponse: MutableLiveData<Response<List<Post>>> = MutableLiveData()

    fun getPost(){
        viewModelScope.launch {
            val response = repository.getPost()
            mResponse.value = response
        }
    }

    fun getPostNumber(number: Int){
        viewModelScope.launch {
            val response = repository.getPostNumber(number)
            mResponse.value = response
        }
    }

    fun getPostUserId(userId: Int){
        viewModelScope.launch {
            val response = repository.getPostUserId(userId)
            mListResponse.value = response
        }
    }

    fun getPostUserIdAndSort(userId: Int, sort: String, order: String){
        viewModelScope.launch {
            val response = repository.getPostUserIdAndSort(userId, sort, order)
            mListResponse.value = response
        }
    }

    fun getPostUserIdAndSortUsingMap(userId: Int, options: Map<String, String>){
        viewModelScope.launch {
            val response = repository.getPostUserIdAndSortUsingMap(userId, options)
            mListResponse.value = response
        }
    }
}
