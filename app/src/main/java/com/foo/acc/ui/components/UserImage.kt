package com.foo.acc.ui.components

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.foo.acc.data.model.User
import com.foo.acc.ui.theme.Sizes
import com.foo.acc.ui.utils.getHouseColor
import com.foo.acc.ui.utils.getInitials
import com.foo.acc.ui.utils.isOnline

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun UserImage(user: User, size: String = Sizes.SMALL) {
    // Network
    val connManager =
        LocalContext.current.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val isOnline = isOnline(connManager)

    // User info
    val name = user.name
    val house = user.house
    val imageUrl = user.image
    val initials = getInitials(name)
    val houseColor = getHouseColor(house)

    // Composable sizes
    val boxSize = if (size == Sizes.SMALL) 64.dp else 256.dp
    val textSize = if (size == Sizes.SMALL) 24.sp else 100.sp
    val borderSize = if (size == Sizes.SMALL) 4.dp else 8.dp

    if (imageUrl.isEmpty() || !isOnline) {
        Box(
            modifier = Modifier
                .size(boxSize)
                .background(Color.Transparent, CircleShape)
                .border(borderSize, houseColor, CircleShape), contentAlignment = Alignment.Center
        ) {
            Text(
                text = initials, fontSize = textSize
            )
        }
    } else {
        AsyncImage(
            model = imageUrl,
            contentDescription = null,
            modifier = Modifier
                .size(boxSize)
                .clip(CircleShape)
                .border(borderSize, houseColor, CircleShape)
                .graphicsLayer(scaleX = 1.3f, scaleY = 1.3f),
        )
    }
}


