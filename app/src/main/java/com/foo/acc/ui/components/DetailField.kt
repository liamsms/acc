package com.foo.acc.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DetailField(key: String, value: String) {
    val valueFormatted = value.ifEmpty { "Missing" }

    Row(horizontalArrangement = Arrangement.spacedBy(2.dp)) {
        Text(text = "$key: ", style = TextStyle(fontSize = 16.sp), fontWeight = FontWeight.Light)
        Text(text = valueFormatted, style = TextStyle(fontSize = 16.sp))
    }
}

