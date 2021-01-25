package com.userslist.repo;

import androidx.lifecycle.LiveData;

import com.userslist.db.dao.UsersDao;
import com.userslist.db.entitiy.User;

import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Created By dorso on 24/01/2021
 **/
public class UsersRepo {

    private final UsersDao usersDao;

    public UsersRepo(UsersDao usersDao) {
        this.usersDao = usersDao;
    }

    public LiveData<List<User>> getUsers(){
        return usersDao.getUsers();
    }

    public void deleteUser(@NotNull User user) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                usersDao.deleteUser(user);
            }
        }).start();
    }
}
