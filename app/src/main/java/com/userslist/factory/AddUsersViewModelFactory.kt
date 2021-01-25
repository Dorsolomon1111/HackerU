package com.userslist.factory

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.userslist.db.AppDatabase.Companion.getInstance
import com.userslist.viewmodel.AddUserViewModel

/**
Created By dorso on 24/01/2021
 **/
class AddUsersViewModelFactory(private val context: Context) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return AddUserViewModel(getInstance(context).usersDao()) as T
    }
}