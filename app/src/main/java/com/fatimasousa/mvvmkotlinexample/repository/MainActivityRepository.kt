package com.fatimasousa.mvvmkotlinexample.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.fatimasousa.mvvmkotlinexample.model.ServicesSetterGetter
import com.fatimasousa.mvvmkotlinexample.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object MainActivityRepository {

    val serviceSetterGetter = MutableLiveData<ServicesSetterGetter>()

    fun getServicesApiCall(): MutableLiveData<ServicesSetterGetter> {

        val call = RetrofitClient.apiInterface.getServices()

        call.enqueue(object: Callback<ServicesSetterGetter> {
            override fun onFailure(call: Call<ServicesSetterGetter>, t: Throwable) {
               // TODO("Not yet implemented")
                Log.v("DEBUG : ", t.message.toString())
            }

            override fun onResponse(
                call: Call<ServicesSetterGetter>,
                response: Response<ServicesSetterGetter>
            ) {
                //TODO("Not yet implemented")
                Log.v("DEBUG : ", response.body().toString())

                val data = response.body()

                //pq do !! ????
                val msg = data!!.message

                serviceSetterGetter.value = ServicesSetterGetter(msg)
            }
        })

        return serviceSetterGetter
    }
}