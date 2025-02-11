package com.starkindustries.mvvmjetpackcompose.ViewModels

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.starkindustries.mvvmjetpackcompose.Api.TweetsApi
import com.starkindustries.mvvmjetpackcompose.Data.Tweets
import com.starkindustries.mvvmjetpackcompose.Keys.Keys
import com.starkindustries.mvvmjetpackcompose.Repository.TweetsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TweetsViewModel @Inject constructor(private val tweetsRepository: TweetsRepository,private val savedStateHandle: SavedStateHandle):ViewModel(){

    val tweets:StateFlow<List<Tweets>>
        get()=tweetsRepository.tweets
    init{
        viewModelScope.launch {

            var category = savedStateHandle.get<String>(Keys.CATEGORY)?:"Dsa"
            tweetsRepository.getTweets(category)
        }
    }
}