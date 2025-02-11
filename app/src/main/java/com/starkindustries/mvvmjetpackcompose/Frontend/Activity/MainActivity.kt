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
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import com.starkindustries.mvvmjetpackcompose.Api.TweetsApi
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

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    LaunchedEffect(Unit) {
                        try {
                            val response = tweetsApi.getQuotes("\$..tweets[?(@.category=='android-development')]")
                            if (response.isSuccessful) {
                                Log.d("Category",response.body().toString())
                            }else{
                                Log.d("CategoryError",response.code().toString()+" "+response.message().toString())
                            }
                        } catch (e: Exception) {
                            Log.e("NETWORK_ERROR", "Exception: ${e.message}")
                        }


                    }
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MvvmJetpackComposeTheme {
        Greeting("Android")
    }
}