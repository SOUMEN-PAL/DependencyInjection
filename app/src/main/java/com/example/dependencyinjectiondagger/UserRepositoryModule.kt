package com.example.dependencyinjectiondagger

import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Scope

@Module
class UserRepositoryModule {

//    @Provides
//    fun getFireBaseRepository():UserRepository{
//        return FirebaseRepository()
//    }

    // FOr using @Binds we need to have the abstract function and abstract class so that it can be initiated
//    @Binds
//    abstract fun getSQLRepository(sqlRepository: SQLRepository) : UserRepository


    @Named("FireBase")
    @Provides
    fun getFireBaseRepository(@Named("mixpanelAnalytics") analyticsService: AnalyticsService) : UserRepository{
        return FirebaseRepository(analyticsService)
    }

    // so here we can have a typo error and so we can make a custom Qualifier
    @Named("SQLRepo")
    @Provides
    fun getSQLRepository(sqlRepository: SQLRepository):UserRepository{
        return sqlRepository
    }

}