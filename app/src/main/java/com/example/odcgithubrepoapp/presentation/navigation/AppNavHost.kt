package com.example.odcgithubrepoapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.githubreposapp.presentation.screens.repo_details_screen.RepoDetailsScreen
import com.example.odcgithubrepoapp.presentation.screens.repo_issues_screen.RepoIssuesScreen
import com.example.odcgithubrepoapp.presentation.screens.repo_list_screen.RepoListScreen
import com.example.odcgithubrepoapp.presentation.utils.Constants.Companion.NAME_ARGUMENT_KEY
import com.example.odcgithubrepoapp.presentation.utils.Constants.Companion.OWNER_ARGUMENT_KEY

@Composable
fun AppNavHost() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screens.RepoListScreen.route
    ) {
        composable(route = Screens.RepoListScreen.route) {
            RepoListScreen { ownerName, name ->
                navController.navigate(Screens.RepoDetailsScreen.passOwnerAndName(ownerName, name))
            }
        }

        composable(route = Screens.RepoIssuesScreen.route) {
            RepoIssuesScreen(navController) }

        composable(
            route = Screens.RepoDetailsScreen.route,
            arguments = listOf(
                navArgument(OWNER_ARGUMENT_KEY){
                    type = NavType.StringType
                },
                navArgument(NAME_ARGUMENT_KEY){
                    type = NavType.StringType
                }
            )
        ){ navBackStackEntry ->
            val owner = navBackStackEntry.arguments?.getString(OWNER_ARGUMENT_KEY)
            val name = navBackStackEntry.arguments?.getString(NAME_ARGUMENT_KEY)
            if (owner!= null && name != null){
                RepoDetailsScreen(
                    owner = owner,
                    name = name,
                    onShowIssuesClicked = {
                        navController.navigate(Screens.RepoIssuesScreen.route)
                    },
                    onClickBack = {
                        navController.popBackStack()
                    }
                )
            }
        }
    }
}