package com.starkindustries.mvvmjetpackcompose.ViewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.viewModelScope
import com.starkindustries.mvvmjetpackcompose.Repository.TweetsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(private val repository:TweetsRepository):ViewModel(){

    val category:StateFlow<List<String>>
        get()=repository.categories
    init {
        viewModelScope.launch {
            repository.getCategories()
        }
    }
}