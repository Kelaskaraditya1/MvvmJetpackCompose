package com.starkindustries.mvvmjetpackcompose.Frontend.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.starkindustries.mvvmjetpackcompose.Frontend.Routes.Routes
import com.starkindustries.mvvmjetpackcompose.R
import com.starkindustries.mvvmjetpackcompose.ViewModels.CategoryViewModel

@Composable
fun CategoryItem(category:String,navController: NavController){

    var background = painterResource(id = R.drawable.blue_wave)

    Box(modifier = Modifier
        .size(200.dp)
        .padding(10.dp)
        .clickable {
            navController.navigate(Routes.TweetsScreen.addRoute(category))
        }){
        Card {
            Box(modifier = Modifier
                .fillMaxSize()){
                Image(painter = background,
                    contentDescription ="")

                Box(modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 10.dp)
                , contentAlignment = Alignment.BottomCenter){
                    Text(text = category
                        , color = Color.White
                        , fontWeight = FontWeight.W500
                        , fontSize = 22.sp
                    , modifier = Modifier
                            .padding(5.dp))
                }
            }
        }
    }
}

@Composable
fun CategoriesScreen(navController: NavController){
    
    var categoryViewModel:CategoryViewModel = hiltViewModel()
    var categories = categoryViewModel.category.collectAsState()
    LazyVerticalGrid(columns = GridCells.Fixed(2)
    , contentPadding = PaddingValues(8.dp)
        , verticalArrangement = Arrangement.SpaceEvenly
    , modifier = Modifier
            .padding(top = 10.dp)) {
        items(categories.value.distinct()){ category->
            CategoryItem(category = category, navController = navController)
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun CategoriesScreenPreivew() {
    CategoriesScreen(rememberNavController())
}