package com.foo.acc.ui.viewmodels

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.foo.acc.data.model.User
import com.foo.acc.data.repository.UserRepository
import kotlinx.coroutines.launch

class UserViewModel(private val userRepository: UserRepository) : ViewModel() {
    private val users = mutableStateListOf<User>()
    private val filter = mutableStateOf("")

    init {
        viewModelScope.launch {
            val data = userRepository.getUsers()
            users.addAll(data)
        }
    }

    fun getFilter(): String {
        return filter.value
    }

    fun setFilter(updated: String) {
        filter.value = updated
    }

    fun getUserById(userId: String?): User? {
        return users.find { it.id == userId }
    }

    fun getFilteredUsers(): List<User> {
        return if (filter.value.isEmpty()) {
            users.toList()
        } else {
            users.filter {
                it.name.contains(
                    filter.value, ignoreCase = true
                ) || it.actor.contains(
                    filter.value, ignoreCase = true
                )
            }
        }
    }
}