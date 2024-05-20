package com.example.dependencyinjectiondagger

import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class UserRepositoryModule {

//    @Provides
//    fun getFireBaseRepository():UserRepository{
//        return FirebaseRepository()
//    }

    // FOr using @Binds we need to have the abstract function and abstract class so that it can be initiated
    @Binds
    abstract fun getSQLRepository(sqlRepository: SQLRepository) : UserRepository
}