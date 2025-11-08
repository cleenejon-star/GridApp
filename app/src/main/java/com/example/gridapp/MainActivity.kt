package com.example.gridapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.gridapp.ui.theme.GridAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            GridAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    MyAppNavigation()
                }
            }
        }
    }
}


@Composable
fun MyAppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "insertRows") {
        // Route for InsertRowsScreen
        composable("insertRows") {
            InsertRowsScreen(navController = navController)
        }

        // Route for InsertColumnsScreen
        composable(
            route = "insertColumns/{rows}",
            arguments = listOf(navArgument("rows") { type = NavType.StringType })
        ) { backStackEntry ->
            InsertColumnsScreen(
                navController = navController,
                rows = backStackEntry.arguments?.getString("rows")
            )
        }

        // Route for GridScreen
        composable(
            route = "gridScreen/{rows}/{cols}",
            arguments = listOf(
                navArgument("rows") { type = NavType.StringType },
                navArgument("cols") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            GridScreen(
                rows = backStackEntry.arguments?.getString("rows"),
                cols = backStackEntry.arguments?.getString("cols")
            )
        }
    }
}