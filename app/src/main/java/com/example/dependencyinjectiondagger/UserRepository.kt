package com.example.dependencyinjectiondagger

import android.content.ContentValues.TAG
import android.util.Log
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton

interface UserRepository {
    fun saveUser(email : String , password: String)
}
@ActivityScope
class SQLRepository @Inject constructor(@Named("firebaseAnalytics")val analyticsService: AnalyticsService):UserRepository{
    override fun saveUser(email : String, password: String){
        Log.d("SIDBOT" , "User Saved in DB")
        analyticsService.trackEvent("SaveUser" , "Create")
    }
}


@ActivityScope
class FirebaseRepository (@Named("mixpanelAnalytics") val analyticsService: AnalyticsService) : UserRepository{

    override fun saveUser(email: String, password: String) {
        Log.d(TAG , "User saved in firebase")
        analyticsService.trackEvent("SaveUser" , "Create")
    }

}