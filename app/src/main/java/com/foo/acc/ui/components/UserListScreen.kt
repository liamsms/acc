package com.foo.acc.ui.components

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.foo.acc.ui.theme.Theme
import com.foo.acc.ui.viewmodels.UserViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun UserListScreen(navController: NavController, userViewModel: UserViewModel) {
    val users = userViewModel.getFilteredUsers()
    val filter = userViewModel.getFilter()
    val setFilter = userViewModel::setFilter

    Theme {
        Scaffold {
            Column(
                modifier = Modifier.padding(24.dp),
                verticalArrangement = Arrangement.spacedBy(24.dp)
            ) {
                Text(
                    text = "Characters",
                    style = TextStyle(fontSize = 38.sp),
                    modifier = Modifier.padding(top = 72.dp)
                )
                SearchBar(
                    filter = filter, setFilter = setFilter
                )
                UserList(
                    users = users, navController = navController
                )
            }
        }
    }
}