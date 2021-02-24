package com.fatimasousa.mvvmkotlinexample.view

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.fatimasousa.mvvmkotlinexample.R
import com.fatimasousa.mvvmkotlinexample.repository.MainActivityRepository.serviceSetterGetter
import com.fatimasousa.mvvmkotlinexample.viewmodel.MainActivityViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var context: Context

    lateinit var mainActivityViewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        context = this@MainActivity

        mainActivityViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        btnClick.setOnClickListener {

            wp7progressBar.showProgressBar()

            mainActivityViewModel.getUser()!!.observe(this, Observer { serviceSetterGetter ->

                wp7progressBar.hideProgressBar()

                val msg = serviceSetterGetter.message

                lblResponse.text = msg
            })

        }

    }
}