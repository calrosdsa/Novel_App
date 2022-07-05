package com.example.novels
sealed class Screen(val route:String){
   object Home : Screen("main/home")
   object BookShelf : Screen("main/bookshelf")
   object Explore : Screen("main/explore")
   object Profile: Screen("main/profile")
}

sealed class LeaftScreen(
    private val route: String
){
   fun createRoute(root: Screen) = "${root.route}/$route"

   object DiscoverScreen:LeaftScreen("?status={status}"){
      fun createRoute(
         root: Screen,
         status: String?,
      ): String {
         return root.route.let {
            if (status != null) "$it?status=$status" else it
         }
      }
   }
}