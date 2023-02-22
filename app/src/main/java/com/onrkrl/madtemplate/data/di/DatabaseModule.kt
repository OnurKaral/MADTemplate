package com.onrkrl.madtemplate.data.di


import android.content.Context
import androidx.compose.runtime.Stable
import com.onrkrl.madtemplate.data.local.dao.AppDao
import com.onrkrl.madtemplate.data.local.db.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Stable
@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun provideAppDao(appDatabase: AppDatabase): AppDao = appDatabase.AppDao()

    @Provides
    @Singleton
    fun provideRickAndMortyDatabase(
        @ApplicationContext context: Context
    ): AppDatabase {
        return AppDatabase.getDatabase(context)
    }
}