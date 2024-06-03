package com.example.dependencyinjectiondagger

import dagger.Component
import javax.inject.Named
import javax.inject.Singleton

@Singleton
@Component(modules = [AnalyticsModule::class])
interface AppComponent {
//    @Named("mixpanelAnalytics")
//    fun getMixpanelAnalyticsService(): AnalyticsService
//
//    @Named("firebaseAnalytics")
//    fun getFirebaseAnalyticsService(): AnalyticsService
//
//    // Jab @Inject nahi use kar rahe ho in the component we need to use the Names anotations for providing the implementations as how would dagger know what to provide

    fun getUserRegistrationComponentBuilder() : UserRegistrationComponent.Builder
}