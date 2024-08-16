package com.foo.acc.ui.components

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.foo.acc.data.model.User
import com.foo.acc.ui.utils.formatDate
import com.foo.acc.ui.utils.formatSpecies
import com.foo.acc.ui.utils.getLifeStatus

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun UserDetails(user: User) {
    val name = user.name
    val actor = user.actor
    val species = user.species
    val dateOfBirth = user.dateOfBirth
    val alive = user.alive
    val lifeFormatted = getLifeStatus(alive)
    val speciesFormatted = formatSpecies(species)
    val dateFormatted = formatDate(dateOfBirth)

    Scaffold {
        Column(
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier
                .padding(24.dp)
                .fillMaxWidth()
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(top = 72.dp)
                    .fillMaxWidth()
            ) {
                UserImage(user = user, size = "large")
            }
            Text(text = name, style = TextStyle(fontSize = 28.sp))
            DetailField(key = "Actor", value = actor)
            DetailField(key = "Species", value = speciesFormatted)
            DetailField(key = "Status", value = lifeFormatted)
            DetailField(key = "Date of birth", value = dateFormatted)
        }
    }
}
