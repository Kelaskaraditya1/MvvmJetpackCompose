package com.starkindustries.mvvmjetpackcompose.Repository

import com.starkindustries.mvvmjetpackcompose.Api.TweetsApi
import com.starkindustries.mvvmjetpackcompose.Data.Tweets
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class TweetsRepository @Inject constructor(private val tweetsApi:TweetsApi) {

    var _tweets = MutableStateFlow<List<Tweets>>(emptyList())
    val tweets:StateFlow<List<Tweets>>
        get() = _tweets

    var _categories = MutableStateFlow<List<String>>(emptyList())
    val categories : StateFlow<List<String>>
        get()=_categories

    suspend fun getCategories(){
        val response = tweetsApi.getCategories()
        if(response.isSuccessful && response.body()!=null){
            _categories.emit(response.body()!!)
        }
    }

    suspend fun getTweets(category:String){
        val response = tweetsApi.getQuotes(category)
        if(response.isSuccessful && response.body()!=null){
            _tweets.emit(response.body()!!)
        }
    }
}