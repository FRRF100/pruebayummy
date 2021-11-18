package com.frodriguez.pruebayummy.model.story

import com.frodriguez.pruebayummy.model.WebService
import com.frodriguez.pruebayummy.utils.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.Exception
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class StoriesRemoteDataSource @Inject constructor() {

    private var retrofit = Retrofit.Builder()
        .baseUrl(Constants.API_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    var service: WebService = retrofit.create(WebService::class.java)

    fun getStories(): List<Story> {
        return try {
            service.getStories()?.execute()?.body()?.hits ?: listOf()
        } catch (ex: Exception){
            emptyList()
        }
    }

}