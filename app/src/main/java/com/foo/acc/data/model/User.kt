package com.foo.acc.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class User(
    @PrimaryKey val id: String,
    val name: String,
    val actor: String,
    val species: String,
    val house: String,
    val dateOfBirth: String?,
    val alive: Boolean,
    val image: String
)