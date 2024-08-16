package com.foo.acc.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.foo.acc.data.model.User
import com.foo.acc.ui.theme.Screens
import com.foo.acc.ui.theme.Theme
import com.foo.acc.ui.utils.formatSpecies

@Composable
fun UserCard(user: User, navController: NavController) {
    val id = user.id
    val name = user.name.ifEmpty { "Name missing" }
    val actor = user.actor.ifEmpty { "Actor missing" }
    val species = user.species.ifEmpty { "Species missing" }
    val speciesFormatted = formatSpecies(species)
    val route = Screens.DETAIL.replace("{id}", id)

    Theme {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    navController.navigate(route)
                },
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(18.dp)
        ) {
            UserImage(user = user)
            Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
                Text(
                    text = name, style = TextStyle(fontSize = 20.sp)
                )
                Text(
                    text = actor, style = TextStyle(fontSize = 16.sp)
                )
                Text(
                    text = speciesFormatted, style = TextStyle(fontSize = 16.sp)
                )
            }
        }
    }
}
