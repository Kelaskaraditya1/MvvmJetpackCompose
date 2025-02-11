package com.starkindustries.mvvmjetpackcompose.Frontend.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.starkindustries.mvvmjetpackcompose.Frontend.Routes.Routes
import com.starkindustries.mvvmjetpackcompose.Frontend.Screens.CategoriesScreen
import com.starkindustries.mvvmjetpackcompose.Frontend.Screens.TweetsCompose
import com.starkindustries.mvvmjetpackcompose.Frontend.Screens.TweetsScreen
import com.starkindustries.mvvmjetpackcompose.Keys.Keys
import okhttp3.Route

@Composable
fun Navigation(){
    var navController = rememberNavController()
    
    NavHost(navController = navController, startDestination = Routes.CategoryScreen.route ){
        composable(Routes.CategoryScreen.route){
            CategoriesScreen(navController)
        }
        composable(Routes.TweetsScreen.route+"/"+"{${Keys.CATEGORY}}", arguments = listOf(
            navArgument(name = Keys.CATEGORY){
                type= NavType.StringType
                defaultValue="Dsa"
            }
        )){
            TweetsScreen()
        }
    }
}