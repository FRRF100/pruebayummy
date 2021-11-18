package com.frodriguez.pruebayummy.model

import retrofit2.Call
import retrofit2.http.GET

interface WebService {

    @GET("search_by_date?query=mobile")
    fun getStories(): Call<WebResponse?>?

}