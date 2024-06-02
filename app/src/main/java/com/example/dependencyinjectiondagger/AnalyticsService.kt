package com.example.dependencyinjectiondagger

import android.nfc.Tag
import android.util.Log

interface AnalyticsService {
    fun trackEvent(eventName : String , eventType : String)
}

class Mixpanel : AnalyticsService{
    override fun trackEvent(eventName: String, eventType: String) {
        Log.d("Analytics" , "Mix Panel $eventName")
    }

}

class FirebaseAnalytics : AnalyticsService{
    override fun trackEvent(eventName: String, eventType: String) {
        Log.d("Analytics" , "firebaseAnalytics $eventName")
    }

}