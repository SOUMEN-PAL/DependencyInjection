package com.example.dependencyinjectiondagger

import androidx.compose.runtime.MutableIntState
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
class NotificationServiceModule() {
    @Singleton
    @MessageQualifier
    @Provides
    fun getMessageService(retryCount : MutableIntState):NotificationService{
        return MessageService(retryCount.intValue)
    }

    @Named("email")
    @Provides
    fun getMailService(popData:Int):NotificationService{
        return EmailService(popData)
    }
}

/*
Now suppose here I need to use both the Email service and the message service and I need both of the instances so for that case we use Qualifiers
 Named Qualifiers are used to differentiate the instances


    @Provides
    fun getMessageService():NotificationService{
        return MessageService()
    }

    @Provides
    fun getMailService(emailService: EmailService):NotificationService{
        return emailService
    }

 */