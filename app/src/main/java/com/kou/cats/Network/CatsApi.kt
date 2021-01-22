package com.kou.cats.Network

import com.kou.cats.Model.Cats
import com.kou.cats.Model.CatsItem
import com.kou.cats.common.UnsafeSSL
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface CatsApi {
    companion object Factory {
        fun create(): CatsApi {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://api.thecatapi.com/v1/")//10.0.2.2:8000 emulator //put ipv4 adress//me192.168.1.4//orange 10.54.234.189
                .client(UnsafeSSL.getUnsafeOkHttpClient().build())
                .build()
            return retrofit.create(CatsApi::class.java)
        }
    }

    /************************* Cat ********************/

    @GET("images/search")
    fun getAcat(@Query("api_key") api_key:String,@Query("size")size:String):Call<Cats>
}