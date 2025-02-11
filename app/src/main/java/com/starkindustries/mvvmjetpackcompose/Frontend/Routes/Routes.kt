package com.starkindustries.mvvmjetpackcompose.Frontend.Routes

import com.starkindustries.mvvmjetpackcompose.Keys.Keys

sealed class Routes(var route:String) {

    object CategoryScreen:Routes(Keys.CATEGORY_SCREEN)
    object TweetsScreen:Routes(Keys.TWEETS_SCREEN)

    fun addRoute(vararg arg:String):String{
        return buildString {
            append(route)
            arg.forEach { arg->
                append("/$arg")
            }
        }
    }
}