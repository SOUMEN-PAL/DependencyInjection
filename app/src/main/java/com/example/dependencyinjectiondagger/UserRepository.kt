package com.example.dependencyinjectiondagger

import android.util.Log
import javax.inject.Inject

class UserRepository @Inject constructor(){
    fun saveUser(email : String , password: String){
        Log.d("SIDBOT" , "User Saved in DB")
    }
}