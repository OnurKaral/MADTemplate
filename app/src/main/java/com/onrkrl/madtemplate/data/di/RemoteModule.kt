package com.onrkrl.madtemplate.data.di

import androidx.compose.runtime.Stable
import com.onrkrl.madtemplate.data.remote.api.CoreAPI
import com.onrkrl.madtemplate.data.remote.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Stable
@Module
@InstallIn(SingletonComponent::class)
class RemoteModule {

    @Singleton
    @Provides
    fun coreApi(): CoreAPI {
        return Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoreAPI::class.java)
    }

}