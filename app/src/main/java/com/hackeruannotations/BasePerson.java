package com.hackeruannotations;

import android.util.Log;

import androidx.annotation.CallSuper;

/**
 * Created By dorso on 06/01/2021
 **/
abstract class BasePerson {

    @CallSuper
    public void doSomething() {
        Log.d("TAG", "I'm the super class");
    }

}
