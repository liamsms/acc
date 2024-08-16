package com.foo.acc.ui.utils

import android.content.Context
import android.net.ConnectivityManager
import androidx.compose.ui.graphics.Color
import androidx.room.Room
import com.foo.acc.data.api.UserApi
import com.foo.acc.data.db.UserDao
import com.foo.acc.data.db.UserDatabase
import com.foo.acc.data.repository.UserRepository
import com.foo.acc.ui.theme.API_URL
import com.foo.acc.ui.theme.DB_NAME
import com.foo.acc.ui.theme.GryffindorPrimaryColor
import com.foo.acc.ui.theme.Houses
import com.foo.acc.ui.theme.HufflepuffPrimaryColor
import com.foo.acc.ui.theme.RavenclawPrimaryColor
import com.foo.acc.ui.theme.SlytherinPrimaryColor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.text.SimpleDateFormat
import java.util.Locale

fun initUserDao(context: Context): UserDao {
    return Room.databaseBuilder(context, UserDatabase::class.java, DB_NAME).build().dao()
}

fun initUserApi(): UserApi {
    return Retrofit.Builder().baseUrl(API_URL).addConverterFactory(GsonConverterFactory.create())
        .build().create(UserApi::class.java)

}

fun initUserRepository(api: UserApi, dao: UserDao): UserRepository {
    return UserRepository(api = api, dao = dao)
}

fun formatDate(date: String?): String {
    if (date == null) return "Unknown"
    val oldFormat = SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH)
    val newFormat = SimpleDateFormat("dd MMM yyyy", Locale.ENGLISH)
    val parseDate = oldFormat.parse(date) ?: return "Date error"
    return newFormat.format(parseDate)
}

fun getLifeStatus(isAlive: Boolean): String {
    return if (isAlive) "Alive" else "Dead"
}

fun getHouseColor(house: String): Color {
    return when (house) {
        Houses.GRYFFINDOR -> GryffindorPrimaryColor
        Houses.SLYTHERIN -> SlytherinPrimaryColor
        Houses.RAVENCLAW -> RavenclawPrimaryColor
        Houses.HUFFLEPUFF -> HufflepuffPrimaryColor
        else -> Color.LightGray
    }
}

fun formatSpecies(species: String): String {
    return species.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
}

fun getInitials(name: String): String {
    return if (name.isEmpty()) {
        "?"
    } else {
        name.first().toString()
    }
}

fun isOnline(connManager: ConnectivityManager): Boolean {
    val net = connManager.activeNetwork
    return net != null
}