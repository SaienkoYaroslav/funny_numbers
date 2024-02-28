package com.example.funnynumbers.ui.navigation

sealed class NavScreen(val route: String) {

    object MainScreen: NavScreen("main_screen")

    object DetailScreen: NavScreen("detail_screen")

}