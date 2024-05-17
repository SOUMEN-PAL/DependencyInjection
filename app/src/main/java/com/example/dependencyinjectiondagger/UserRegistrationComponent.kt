package com.example.dependencyinjectiondagger

import dagger.Component

@Component(modules = [UserRepositoryModule::class , NotificationServiceModule::class])
interface UserRegistrationComponent {
//    fun getUserRegistrationService() : UserRegistration
//    fun getEmailRegistrationService() : EmailService

    // Now me 50 dependency toh ispe nahi list karunga so rather than doing that ham mainActivity ko hi pass karenge so that Dagger will deal with it

    fun inject(mainActivity: MainActivity)
}