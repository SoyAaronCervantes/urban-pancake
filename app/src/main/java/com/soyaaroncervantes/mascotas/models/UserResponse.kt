package com.soyaaroncervantes.mascotas.models

import com.google.gson.annotations.SerializedName

data class UserResponse(
    @SerializedName("users" ) val users: List<User>,
    @SerializedName("count" ) val count: Int,
)
