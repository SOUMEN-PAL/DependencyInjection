package com.example.dependencyinjectiondagger

import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class AnalyticsModule {
    @Named("mixpanelAnalytics")
    @Provides
    fun getAnalyticsService() : AnalyticsService{
        return Mixpanel()
    }

    @Named("firebaseAnalytics")
    @Provides
    fun getFirebaseAnalytics() : AnalyticsService{
        return FirebaseAnalytics()
    }
}