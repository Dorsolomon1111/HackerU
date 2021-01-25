package com.userslist.viewmodel

import androidx.lifecycle.ViewModel
import com.userslist.db.dao.UsersDao
import com.userslist.db.entitiy.User
import com.userslist.repo.AddUserRepo

/**
Created By dorso on 24/01/2021
 **/
class AddUserViewModel(usersDao: UsersDao) : ViewModel() {

    private val addUserRepo = AddUserRepo(usersDao)

    fun addUser(user: User) {
        addUserRepo.insertUser(user)
    }
}