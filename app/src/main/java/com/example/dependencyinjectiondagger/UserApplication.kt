package com.example.dependencyinjectiondagger

import android.app.Application
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.mutableIntStateOf


class UserApplication : Application() {

//    lateinit var userRegistrationComponent: UserRegistrationComponent
//    private var retryCount : MutableIntState = mutableIntStateOf(4)
    lateinit var appComponent: AppComponent
    override fun onCreate() {
        super.onCreate()

//        userRegistrationComponent = DaggerUserRegistrationComponent.factory().create( retryCount, 2)
        appComponent = DaggerAppComponent.builder().build()
    }
}