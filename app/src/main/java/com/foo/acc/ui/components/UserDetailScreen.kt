package com.foo.acc.ui.components

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import com.foo.acc.ui.viewmodels.UserViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun UserDetailScreen(userViewModel: UserViewModel, userId: String?) {
    val user = userViewModel.getUserById(userId)

    if (user != null) {
        UserDetails(user = user)
    } else {
        UserNotFound()
    }
}
