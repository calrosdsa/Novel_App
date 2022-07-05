package com.example.novels.navigation

import android.content.Context
import android.widget.Toast
import androidx.compose.animation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.*
import com.example.bookmark.BookMarkScreen
import com.example.detail.NovelDetail
import com.example.discover.DiscoverScreen
import com.example.history.HistoryNovelScreen
import com.example.login.LoginScreen
import com.example.novels.MainDestination
import com.example.novels.Screen
import com.example.novels.composable
import com.example.profile.ProfileScreen
import com.example.recommended.RecommendedScreen
import com.google.accompanist.navigation.animation.navigation
import com.example.screen.NovelPage
import com.example.screen.NovelScreen
import com.example.search.SearchScreen
import com.example.search.pagination.AllHistory

@ExperimentalAnimationApi
fun NavGraphBuilder.homeGraph(
   state: ScaffoldState,
   navController: NavController,
   modifier: Modifier = Modifier,
   context: Context
) {
    navigation(
       route = MainDestination.HOME_ROUTE,
       startDestination = Screen.Home.route,
    ){
     addHomeGraph(navController,scaffoldState =state)
       addBookShelfGraph(navController,state = state)
       addExploreGraph(navController,state = state)
       addProfileGraph(navController,context = context,modifier = modifier,state=state)
    }
   composableDetail(route = MainDestination.NOVEL_DETAIL + "/{novelSlug}"){
      NovelDetail(navController = navController)
   }
   composableDetail(route = MainDestination.SEARCH_SCREEN){
      SearchScreen(navController = navController)
   }
   composableDetail(route = MainDestination.LOGIN_SCREEN){
      LoginScreen(navController = navController)
   }
   composableDetail(route = MainDestination.LOGIN_SCREEN){
      LoginScreen(navController = navController)
   }
   composableDetail(route = MainDestination.HISTORY_NOVEL){
      HistoryNovelScreen(navController = navController)
   }
   composableDetail(route = MainDestination.RECOMMENDED_SCREEN){
      RecommendedScreen(navController = navController)
   }
   composableRecommended(route = MainDestination.RECOMMENDED_SCREEN){
      RecommendedScreen(navController = navController)
   }
   composableRecommended(route = MainDestination.HISTORY_SEARCH){
      AllHistory(navController = navController)
   }

}


@ExperimentalAnimationApi
fun NavGraphBuilder.addHomeGraph(
   navController: NavController,
   scaffoldState: ScaffoldState
  // modifier: Modifier
) {


   composable(route = Screen.Home.route,
      debugLabel = "Home()",
   ) {
      Box(modifier = Modifier
         .fillMaxSize()
         .padding(bottom = 56.5.dp)
      ) {
         NovelScreen(navController = navController, scaffoldState = scaffoldState)
      }
   }
}



@ExperimentalAnimationApi
private fun NavGraphBuilder.addBookShelfGraph(
   navController: NavController,
   state :ScaffoldState,
) {
   composable(
      route = Screen.BookShelf.route,
      debugLabel = "BookMark()",
   ) {
      Box(modifier = Modifier
         .fillMaxSize()
         .padding(bottom = 56.5.dp)
      ) {
         BookMarkScreen(navController, state)
      }
   }
}

@Composable
fun ProfileTest(){
      Text(text = "ClickHeeee")
}

@ExperimentalAnimationApi
private fun NavGraphBuilder.addProfileGraph(
   navController: NavController,
   modifier: Modifier,
   context: Context,
   state: ScaffoldState
) {
   composable(route = Screen.Profile.route,
      debugLabel = "Profile()",
   ) {

      Box(modifier = Modifier
         .fillMaxSize()
         .padding(bottom = 56.5.dp)
      ) {
         ProfileScreen(
            context = context,
            navController = navController,
            loginScreen = MainDestination.LOGIN_SCREEN,
            scaffoldState = state,
            modifier = modifier
         )
      }
   }
}

@ExperimentalAnimationApi
private fun NavGraphBuilder.addExploreGraph(navController: NavController,state: ScaffoldState) {
   composable(route = Screen.Explore.route + "?status={status}&category={category}&ordering={ordering}",
      arguments = listOf(navArgument("status"){
         type = NavType.StringType
         nullable = true
      },navArgument("category"){
         type = NavType.StringType
         nullable = true
      },navArgument("ordering"){
         type = NavType.StringType
         nullable = true
      }),
      debugLabel = "ExploreGraph",
   ) {
      //Tutorial5_1Screen()
      Box(modifier = Modifier
         .fillMaxSize()
         .padding(bottom = 56.5.dp)
      ) {
      DiscoverScreen(navController, scaffoldState = state)
      }
    //  RecommendedScreen(navController = navController)
   }
}


@Composable
fun NovelMain(){
   var showDisposableEffectSample by remember { mutableStateOf(false) }

   Column() {


   OutlinedButton(onClick = {  showDisposableEffectSample = !showDisposableEffectSample
   }) {
      Text("Display DisposableEffect sample")
      }

   if (showDisposableEffectSample) {
      DisposableEffectExample()
   }

   }
}


@Composable
private fun DisposableEffectExample() {

   val context = LocalContext.current

   DisposableEffect(
      key1 = Unit,
      effect = {

         Toast.makeText(
            context,
            "DisposableEffectSample composition ENTER",
            Toast.LENGTH_SHORT
         ).show()

         // 🔥 Called just before exiting composition
         onDispose {
            Toast.makeText(
               context,
               "DisposableEffectSample composition EXIT",
               Toast.LENGTH_SHORT
            )
               .show()

         }
      }
   )

   Column(modifier = Modifier.background(Color(0xffFFB300))) {
      Text(
         text = "Disposable Effect Enter/Exit sample",
         color = Color.White,
         modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
      )
   }

}




