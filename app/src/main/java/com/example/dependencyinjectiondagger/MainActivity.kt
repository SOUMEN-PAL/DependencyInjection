package com.example.dependencyinjectiondagger

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.dependencyinjectiondagger.ui.theme.DependencyInjectionDaggerTheme
import java.lang.annotation.RetentionPolicy
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Scope

class MainActivity : ComponentActivity() {
    // Every late int var need a Inject when we call for dependencies
    //This is field Injection

    @Inject
    lateinit var userRegistrationService:UserRegistration

    @Inject
    @Named("email") lateinit var mailService:NotificationService



    @Inject
    @Named("SQLRepo") lateinit var SQLService : UserRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DependencyInjectionDaggerTheme {
                // Manual Dependency Dagger

                // Create an instance of the class

                val retryCount = remember {
                    mutableIntStateOf(0)
                }

                val appComponent = (application as UserApplication).appComponent
                val userRegistrationComponent = DaggerUserRegistrationComponent.factory().create( retryCount, 2 , appComponent)
                userRegistrationComponent.inject(this)


                userRegistrationService.registerUser("sonu@gmail.com", "123456")
                mailService.send("Pata nahi" , "patania" , "hello")
                SQLService.saveUser("ffafs", "afdsfsd")


                Column(modifier = Modifier
                    .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Button(onClick = {
                        retryCount.intValue++
                    }) {
                        Text(text = "Button")
                    }
                }
            }
        }
    }
}

/*
so after performing manual dependency injection i can see that the object of
UserRepository and EmailService is created in MainActivity and passed to UserRegistration class.
and can be used individually.
and unit testing can be done easily.
 */
