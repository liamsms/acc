package com.foo.acc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.foo.acc.ui.components.UserDetailScreen
import com.foo.acc.ui.components.UserListScreen
import com.foo.acc.ui.theme.ID_PARAM
import com.foo.acc.ui.theme.Screens
import com.foo.acc.ui.theme.Theme
import com.foo.acc.ui.utils.initUserApi
import com.foo.acc.ui.utils.initUserDao
import com.foo.acc.ui.utils.initUserRepository
import com.foo.acc.ui.viewmodels.UserViewModel


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val dao = initUserDao(this)
        val api = initUserApi()
        val repo = initUserRepository(api, dao)
        val userViewModel = UserViewModel(repo)

        enableEdgeToEdge()
        setContent { App(userViewModel) }
    }
}

@Composable
fun App(userViewModel: UserViewModel) {
    val navController = rememberNavController()

    Theme {
        NavHost(navController = navController, startDestination = Screens.LIST) {
            composable(Screens.LIST) {
                UserListScreen(
                    navController, userViewModel
                )
            }
            composable(Screens.DETAIL) { backstackEntry ->
                UserDetailScreen(
                    userViewModel, backstackEntry.arguments?.getString(ID_PARAM)
                )
            }
        }
    }
}
