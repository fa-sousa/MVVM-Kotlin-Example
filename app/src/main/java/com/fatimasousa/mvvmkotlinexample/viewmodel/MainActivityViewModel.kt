package com.fatimasousa.mvvmkotlinexample.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fatimasousa.mvvmkotlinexample.model.ServicesSetterGetter
import com.fatimasousa.mvvmkotlinexample.repository.MainActivityRepository

class MainActivityViewModel : ViewModel() {

    var servicesLiveData : MutableLiveData<ServicesSetterGetter>? = null

    fun getUser() : LiveData<ServicesSetterGetter>? {
        servicesLiveData = MainActivityRepository.getServicesApiCall()
        return servicesLiveData
    }

}