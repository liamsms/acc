package com.foo.acc.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.foo.acc.data.model.User

@Database(entities = [User::class], version = 1)
abstract class UserDatabase : RoomDatabase() {
    abstract fun dao(): UserDao
}