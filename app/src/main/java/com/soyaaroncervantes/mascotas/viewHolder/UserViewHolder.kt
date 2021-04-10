package com.soyaaroncervantes.mascotas.viewHolder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.soyaaroncervantes.mascotas.databinding.ItemLayoutBinding
import com.soyaaroncervantes.mascotas.models.User
import com.squareup.picasso.Picasso

class UserViewHolder( view: View): RecyclerView.ViewHolder( view ) {
    private val binding = ItemLayoutBinding.bind( view )
    fun bind( user: User ) {
        // toDo Fill User Info
        binding.fistName.text = user.firstName
        binding.lastName.text = user.lastName
        binding.price.text = "$ ${ user.price }"
        binding.country.text = "${user.country},"
        binding.state.text = user.state
        binding.description.text = user.description
        Picasso.get().load( "https://picsum.photos/1000/1000" ).into( binding.photo )

    }
}