package com.example.aka.ui.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BaseViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "База знаний"
    }
    val text: LiveData<String> = _text
}