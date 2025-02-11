package com.starkindustries.mvvmjetpackcompose.Api

import com.starkindustries.mvvmjetpackcompose.Data.Tweets
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query

interface TweetsApi {

    @GET("b/67aae3fcacd3cb34a8dd8ed8?meta=false")
    suspend fun getQuotes(@Header("X-JSON-Path") category: String): Response<List<Tweets>>



    @GET("b/67aae3fcacd3cb34a8dd8ed8?meta=false")
    @Headers("X-JSON-Path:tweets..category")
    suspend fun getCategories(): Response<List<String>>

}