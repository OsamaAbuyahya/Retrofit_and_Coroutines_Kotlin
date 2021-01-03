package os.abuyahya.retrofitandcoroutineskotlin.repository

import os.abuyahya.retrofitandcoroutineskotlin.api.RetrofitInstance
import os.abuyahya.retrofitandcoroutineskotlin.model.Post
import retrofit2.Response

class Repository {

    suspend fun getPost(): Response<Post> {
        return RetrofitInstance.api.getPost()
    }

    suspend fun getPostNumber(number: Int): Response<Post>{
        return RetrofitInstance.api.getPostNumber(number)
    }

    suspend fun getPostUserId(userId: Int): Response<List<Post>>{
        return RetrofitInstance.api.getPostUserId(userId)
    }

    suspend fun getPostUserIdAndSort(userId: Int, sort: String, order: String): Response<List<Post>>{
        return RetrofitInstance.api.getPostUserIdAndSort(userId, sort, order)
    }

    suspend fun getPostUserIdAndSortUsingMap(userId: Int, options: Map<String, String>): Response<List<Post>>{
        return RetrofitInstance.api.getPostUserIdAndSortUsingMap(userId, options)
    }
}
