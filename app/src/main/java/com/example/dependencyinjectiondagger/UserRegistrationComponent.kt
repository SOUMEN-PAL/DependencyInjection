package com.example.dependencyinjectiondagger

import androidx.compose.runtime.MutableIntState
import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import dagger.Subcomponent
import javax.inject.Singleton

@ActivityScope
@Subcomponent(modules = [UserRepositoryModule::class , NotificationServiceModule::class])
interface UserRegistrationComponent {
//    fun getUserRegistrationService() : UserRegistration
//    fun getEmailRegistrationService() : EmailService

    // Now me 50 dependency toh ispe nahi list karunga so rather than doing that ham mainActivity ko hi pass karenge so that Dagger will deal with it

    fun inject(mainActivity: MainActivity)

//Used Builder pattern in SUbcomponent
    @Subcomponent.Builder
    interface Builder{

        fun build() : UserRegistrationComponent
        fun retryCount(@BindsInstance retryCount : MutableIntState) : Builder
        fun popData(@BindsInstance popData : Int) : Builder

    //        fun create(@BindsInstance retryCount : MutableIntState , @BindsInstance popData : Int) : UserRegistrationComponent
    }
}