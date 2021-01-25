package com.userslist.factory;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.userslist.db.AppDatabase;
import com.userslist.viewmodel.UsersViewModel;

/**
 * Created By dorso on 24/01/2021
 **/
public class UsersViewModelFactory implements ViewModelProvider.Factory {

    private final Context context;

    public UsersViewModelFactory(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new UsersViewModel(AppDatabase.Companion.getInstance(context).usersDao());
    }
}
