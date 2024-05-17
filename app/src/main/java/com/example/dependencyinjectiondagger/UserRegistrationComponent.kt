package com.example.dependencyinjectiondagger

import dagger.Component

@Component
interface UserRegistrationComponent {
    fun getUserRegistrationService() : UserRegistration
    fun getEmailRegistrationService() : EmailService
}