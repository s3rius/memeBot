package com.company.s3rius.memebot.utils

import com.company.s3rius.memebot.model.ApiChats
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiCalls {
    @GET("execute.{function}?")
    fun getChats(@Path("function") function:String, @Query("offset") offset: Int, @Query("count") count: Int, @Query("access_token") accessToken: String, @Query("v") v: String = "5.68"): Observable<ApiChats>
}