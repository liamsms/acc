package com.foo.acc.data.api

import com.foo.acc.data.model.User
import retrofit2.http.GET

interface UserApi {
    @GET("/api/characters")
    suspend fun getUsers(): List<User>
}