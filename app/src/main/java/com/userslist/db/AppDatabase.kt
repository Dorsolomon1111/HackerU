package com.userslist.db

import android.content.Context
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.userslist.db.dao.UsersDao
import com.userslist.db.entitiy.User

/**
Created By dorso on 24/01/2021
 **/
@Database(entities = [User::class], version = 2)
abstract class AppDatabase : RoomDatabase() {

    companion object {

        private var appDatabase: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase{
            if (appDatabase == null)
                appDatabase = Room.databaseBuilder(context, AppDatabase::class.java, "Main DB").fallbackToDestructiveMigration().build()
            return appDatabase!!
        }
    }

    abstract fun usersDao(): UsersDao
}