package com.example.testcode.di

import android.app.Application
import com.example.testcode.db.AppDao
import com.example.testcode.db.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun getAppDb(context: Application) : AppDatabase{
        return AppDatabase.getAppDB(context)
    }

    @Singleton
    @Provides
    fun getDao(appDb: AppDatabase) : AppDao {
        return appDb.getDAO()
    }
}