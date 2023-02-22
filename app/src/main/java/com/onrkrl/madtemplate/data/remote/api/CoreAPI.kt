package com.onrkrl.madtemplate.data.remote.api

import retrofit2.http.GET

interface CoreAPI {

    @GET("template/base")
    suspend fun basetemplate(): String
}