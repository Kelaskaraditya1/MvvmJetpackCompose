package com.starkindustries.mvvmjetpackcompose.Frontend.Activity

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.starkindustries.mvvmjetpackcompose.Api.TweetsApi
import com.starkindustries.mvvmjetpackcompose.Frontend.Navigation.Navigation
import com.starkindustries.mvvmjetpackcompose.Frontend.Screens.CategoriesScreen
import com.starkindustries.mvvmjetpackcompose.Frontend.Screens.TweetsScreen
import com.starkindustries.mvvmjetpackcompose.ViewModels.TweetsViewModel
import com.starkindustries.mvvmjetpackcompose.ui.theme.MvvmJetpackComposeTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var tweetsApi: TweetsApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MvvmJetpackComposeTheme {
                Application()
            }
        }
    }
}

@Composable
fun Application(){

    var tweetsViewModel:TweetsViewModel = viewModel()
    var tweetList = tweetsViewModel.tweets.collectAsState()
    Log.d("Tweets",tweetList.value.toString())
    Navigation()
}

