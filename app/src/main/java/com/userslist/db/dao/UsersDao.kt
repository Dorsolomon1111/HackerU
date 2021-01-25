package com.userslist.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.userslist.db.entitiy.User

/**
Created By dorso on 24/01/2021
 **/
@Dao
interface UsersDao {

    @Query("SELECT * FROM User")
    fun getUsers(): LiveData<List<User>>

    @Insert
    fun insertUser(user: User)

    @Delete
    fun deleteUser(user: User)

    @Query("DELETE FROM User")
    fun deleteAll()
}