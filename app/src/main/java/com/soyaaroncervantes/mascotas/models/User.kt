package com.soyaaroncervantes.mascotas.models

import com.google.gson.annotations.SerializedName

data class User(
    val id: String,
    val createdAt: String,
    val firstName: String,
    val avatar: String,
    val lastName: String,
    val username: String,
    val price: String,
    val country: String,
    val state: String,
    val description: String,
    val email: String
)
