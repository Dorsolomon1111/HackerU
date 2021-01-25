package com.userslist.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.userslist.db.dao.UsersDao
import com.userslist.db.entitiy.User
import com.userslist.repo.UsersRepo

/**
Created By dorso on 24/01/2021
 **/
class UsersViewModel(usersDao: UsersDao) : ViewModel() {

    private val usersRepo = UsersRepo(usersDao)

    val users: LiveData<List<User>> = usersRepo.users

    fun deleteUser(user: User) {
        usersRepo.deleteUser(user)
    }

}