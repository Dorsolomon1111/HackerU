package com.userslist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}

/*
* 1. Navigation - !
* 2. ViewModel - !
* 3. LiveData - !
* 4. Repo - !
* 5. ViewBinding - !
* 6. Room - !
* 7. Loading Images - Glide - !
* 8. RecyclerView !
*
* 1. Activity - !
* 2. Fragment - !
*
* Arch:
*   Single Activity many fragments
*
* Will use:
*  Java + Kotlin
*
* It will have one screen, displaying a list of users, will be able to add users to the list using a dialog/another screen
*/