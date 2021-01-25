package com.userslist.extention

import android.widget.EditText

/**
Created By dorso on 24/01/2021
 **/
val EditText.value: String
get() = text.toString().trim()