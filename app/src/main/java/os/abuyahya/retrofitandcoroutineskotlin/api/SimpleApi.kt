package os.abuyahya.retrofitandcoroutineskotlin.api

import os.abuyahya.retrofitandcoroutineskotlin.model.Post
import retrofit2.Response
import retrofit2.http.*

interface SimpleApi {

    @GET("posts/1")
    suspend fun getPost(): Response<Post>

    @GET("posts/{postNumber}")
    suspend fun getPostNumber(
        @Path("postNumber") number: Int
    ): Response<Post>

    @GET("posts")
    suspend fun getPostUserId(
        @Query("userId") userId: Int
    ): Response<List<Post>>

    @GET("posts")
    suspend fun getPostUserIdAndSort(
        @Query("userId") userId: Int,
        @Query("_sort") sort: String,
        @Query("_order") order: String
    ):Response<List<Post>>

    @GET("posts")
    suspend fun getPostUserIdAndSortUsingMap(
        @Query("userId") userId: Int,
        @QueryMap options: Map<String,String>
    ):Response<List<Post>>


    // Json Format
    @POST("posts")
    suspend fun pushPost(
        @Body post: Post
    ): Response<Post>

    // Key and Value Format
    @FormUrlEncoded
    @POST("posts")
    suspend fun pushPost2(
        @Field("userId") userId: Int,
        @Field("id") id: Int,
        @Field("title") title: Int,
        @Field("body") body: Int,
    ): Response<Post>


}
