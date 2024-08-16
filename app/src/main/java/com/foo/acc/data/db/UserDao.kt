package com.foo.acc.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.foo.acc.data.model.User

@Dao
interface UserDao {
    @Query("SELECT * FROM User")
    suspend fun getUsers(): List<User>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun setUsers(users: List<User>)
}