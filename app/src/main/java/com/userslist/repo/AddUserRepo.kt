package com.userslist.repo

import com.userslist.db.dao.UsersDao
import com.userslist.db.entitiy.User

/**
Created By dorso on 24/01/2021
 **/
class AddUserRepo(private val usersDao: UsersDao) {

    fun insertUser(user: User) {
        Thread {
            usersDao.insertUser(user)
        }.start()
    }
}