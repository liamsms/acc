package com.foo.acc.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color

@Composable
fun SearchBar(filter: String, setFilter: (updated: String) -> Unit) {
    TextField(
        value = filter,
        onValueChange = { updated -> setFilter(updated) },
        label = { Text(text = "Search by name or actor") },
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(100)),
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        )
    )
}