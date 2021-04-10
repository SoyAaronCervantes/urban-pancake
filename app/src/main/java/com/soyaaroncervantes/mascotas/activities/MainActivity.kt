package com.soyaaroncervantes.mascotas.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.soyaaroncervantes.mascotas.adapter.UserAdapter
import com.soyaaroncervantes.mascotas.databinding.ActivityMainBinding
import com.soyaaroncervantes.mascotas.interfaces.UserAPI
import com.soyaaroncervantes.mascotas.models.User
import com.soyaaroncervantes.mascotas.singletons.Singletons
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
  private lateinit var binding: ActivityMainBinding
  private lateinit var adapter: UserAdapter

  private val users = mutableListOf<User>()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate( layoutInflater )
    initRecyclerView()
    getUserData()
    setContentView( binding.root )
  }



  private fun initRecyclerView() {
    adapter = UserAdapter( users )
    binding.recyclerViewMain.layoutManager = LinearLayoutManager( this )
    binding.recyclerViewMain.adapter = adapter
  }

  private fun getUserData() {

    CoroutineScope( Dispatchers.IO ).launch {
      val client = Singletons.retrofit
      val response = client.create( UserAPI::class.java ).getUsers( "users" )

      runOnUiThread {
        response.let {
          val data = response.body();
          if ( it.isSuccessful ) updateUsers( data?.users ?: emptyList() ) else showError()
        }

      }

    }

  }

  private fun updateUsers( value: List<User> ) {
    users.clear()
    users.addAll( value )
    adapter.notifyDataSetChanged()
  }

  private fun showError() {
    val toast = Toast.makeText(this, "Something has happened", Toast.LENGTH_SHORT )
    toast.show()
  }

}