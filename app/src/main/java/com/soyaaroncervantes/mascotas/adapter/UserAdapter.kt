package com.soyaaroncervantes.mascotas.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.soyaaroncervantes.mascotas.R
import com.soyaaroncervantes.mascotas.models.User
import com.soyaaroncervantes.mascotas.viewHolder.UserViewHolder

class UserAdapter( private val users: List<User> ): RecyclerView.Adapter<UserViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val layoutInflater = LayoutInflater.from( parent.context )
        return  UserViewHolder( layoutInflater.inflate( R.layout.item_layout, parent, false ) )
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val item = users[ position ]
        holder.bind( item )
    }

    override fun getItemCount(): Int {
        return users.size
    }
}