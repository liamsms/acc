package com.foo.acc.data.repository

import com.foo.acc.data.api.UserApi
import com.foo.acc.data.db.UserDao
import com.foo.acc.data.model.User

class UserRepository(private val api: UserApi, private val dao: UserDao) {
    suspend fun getUsers(): List<User> {
        try {
            val users = api.getUsers()
            dao.setUsers(users)
            return users
        } catch (error: Exception) {
            return dao.getUsers()
        }
    }
}
