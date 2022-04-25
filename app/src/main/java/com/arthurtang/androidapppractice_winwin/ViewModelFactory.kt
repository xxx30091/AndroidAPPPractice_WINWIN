package com.arthurtang.androidapppractice_winwin

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.arthurtang.androidapppractice_winwin.main.MainViewModel
import java.lang.IllegalArgumentException

class ViewModelFactory() : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}