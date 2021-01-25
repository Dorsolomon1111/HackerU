package com.userslist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.userslist.R
import com.userslist.databinding.RowUserBinding
import com.userslist.db.entitiy.User

/**
Created By dorso on 24/01/2021
 **/
class UsersAdapter : ListAdapter<User, UsersAdapter.ViewHolder>(UsersItemCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(RowUserBinding.inflate(LayoutInflater.from(parent.context), parent, false))


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = getItem(position)
        holder.binder.tvUserId.text = user.id.toString()
        holder.binder.tvUserName.text = user.name
        holder.binder.tvUserAddress.text = user.address
        holder.binder.tvBirthDay.text = user.birthDay
        Glide.with(holder.binder.imgUserProfile).load(
            user.profileImage
        ).placeholder(R.drawable.ic_baseline_person_24).into(holder.binder.imgUserProfile)
    }

    class ViewHolder(val binder: RowUserBinding) : RecyclerView.ViewHolder(binder.root) {

    }

    class UsersItemCallback : DiffUtil.ItemCallback<User>() {

        override fun areItemsTheSame(oldItem: User, newItem: User) = oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: User, newItem: User) = oldItem == newItem

    }
}