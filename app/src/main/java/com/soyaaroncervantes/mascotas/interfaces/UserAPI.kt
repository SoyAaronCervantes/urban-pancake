package com.soyaaroncervantes.mascotas.interfaces

import com.soyaaroncervantes.mascotas.models.UserResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface UserAPI {
    @GET
    suspend fun getUsers( @Url route: String ): Response<UserResponse>
}