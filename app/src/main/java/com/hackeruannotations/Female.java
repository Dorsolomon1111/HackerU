package com.hackeruannotations;

import android.util.Log;

/**
 * Created By dorso on 06/01/2021
 **/
class Female extends BasePerson {

    @Override
    public void doSomething() {
        super.doSomething();
        Log.d("TAG", "And im the child class");
    }
}
