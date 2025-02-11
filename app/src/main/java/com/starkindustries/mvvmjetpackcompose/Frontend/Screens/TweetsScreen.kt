package com.starkindustries.mvvmjetpackcompose.Frontend.Screens

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.starkindustries.mvvmjetpackcompose.Data.Tweets
import com.starkindustries.mvvmjetpackcompose.ViewModels.TweetsViewModel


@Composable
fun TweetsCompose(tweets: String){
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(100.dp)
        .padding(5.dp)
        .border(width = 1.dp, shape = RectangleShape, color = Color.Black)
    , contentAlignment = Alignment.CenterStart){
        Text(text = tweets
        , modifier = Modifier
                .padding(10.dp)
        , fontSize = 20.sp
        , fontWeight = FontWeight.W500)
    }
}

@Composable
fun TweetsScreen(){
    var tweetsViewModel:TweetsViewModel = hiltViewModel()
    var tweets = tweetsViewModel.tweets.collectAsState()

    LazyColumn(modifier = Modifier
        .fillMaxSize()) {
        items(tweets.value){ tweet->
            TweetsCompose(tweets = tweet.quote)
        }
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun TweetsPreview() {
    TweetsScreen()
}