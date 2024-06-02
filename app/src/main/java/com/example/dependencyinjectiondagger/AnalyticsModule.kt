package com.example.dependencyinjectiondagger

import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton


@Module
class AnalyticsModule {

    @Named("mixpanelAnalytics")
    @Provides
    @Singleton
    fun getAnalyticsService() : AnalyticsService{
        return Mixpanel()
    }


    @Named("firebaseAnalytics")
    @Provides
    @Singleton
    fun getFirebaseAnalytics() : AnalyticsService{
        return FirebaseAnalytics()
    }
}