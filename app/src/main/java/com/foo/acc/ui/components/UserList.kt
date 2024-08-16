package com.foo.acc.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.foo.acc.data.model.User

@Composable
fun UserList(users: List<User>, navController: NavController) {
    if (users.isEmpty()) {
        Text(text = "No characters found")
    } else {
        LazyColumn(verticalArrangement = Arrangement.spacedBy(24.dp)) {
            items(users) { user ->
                UserCard(
                    user = user, navController = navController
                )
            }
        }
    }
}