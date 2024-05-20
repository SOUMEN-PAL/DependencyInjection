package com.example.dependencyinjectiondagger

import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class NotificationServiceModule {

    @Named("message")
    @Provides
    fun getMessageService():NotificationService{
        return MessageService()
    }

    @Named("email")
    @Provides
    fun getMailService(emailService: EmailService):NotificationService{
        return emailService
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