package com.soyaaroncervantes.mascotas.utilities

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitUtility {

  companion object {
    fun baseURL(): Retrofit {
      return Retrofit.Builder()
        .baseUrl("https://5f90ba3be0559c0016ad6cb1.mockapi.io/v1/")
        .addConverterFactory( GsonConverterFactory.create() )
        .build()
    }

  }

}