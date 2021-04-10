package com.soyaaroncervantes.mascotas.singletons

import com.soyaaroncervantes.mascotas.utilities.RetrofitUtility

object Singletons {
  val retrofit = RetrofitUtility.baseURL()
}