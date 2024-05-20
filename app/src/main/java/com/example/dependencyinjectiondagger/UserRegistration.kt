package com.example.dependencyinjectiondagger

import javax.inject.Inject
import javax.inject.Named


// and the inject was constructer Injection
class UserRegistration @Inject constructor(
    private val userRespository: UserRepository ,
    @Named("email") private val notificationService: NotificationService
) {

    fun registerUser(email : String , password : String){
        userRespository.saveUser(email , password)
        notificationService.send(email , "no-reply@xyzgmail.com" , "Welcome to our App")
    }

}


/*
Problems with the current format

*Unit testing
*Single Responsibility Principle
*Lifetime of the object
*Extensibility

Now I would be manually resolving the dependencies using manual dependency injection.
so in UserResgistration class I have created the object of UserRepository and EmailService.
I will use constructor injection to inject the dependencies.

class UserRegistration(private val userRespository: UserRepository ,
                       private val emaiService: EmailService
)

Now I will create the object of UserRegistration in MainActivity and pass the dependencies.
and we resolve the dependencies manually.

 */