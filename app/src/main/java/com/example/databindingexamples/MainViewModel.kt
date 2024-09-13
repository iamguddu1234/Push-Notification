package com.example.databindingexamples

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    private val _username = MutableLiveData<String>()

    val username: LiveData<String> get() = _username

    init {
        _username.value = ""
    }

    fun setUserName(newUserName : String){
        _username.value = newUserName
    }
}