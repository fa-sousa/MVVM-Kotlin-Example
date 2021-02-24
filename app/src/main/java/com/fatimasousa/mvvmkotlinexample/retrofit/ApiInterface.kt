package com.fatimasousa.mvvmkotlinexample.retrofit

import com.fatimasousa.mvvmkotlinexample.model.ServicesSetterGetter
import retrofit2.http.GET

interface ApiInterface {

    @GET("1804cbf3-62a0-4363-a0c7-b6553c0b14b9")
    fun getServices() : retrofit2.Call<ServicesSetterGetter>
}