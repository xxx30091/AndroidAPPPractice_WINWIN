package com.arthurtang.androidapppractice_winwin.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arthurtang.androidapppractice_winwin.data.ContentData
import com.arthurtang.androidapppractice_winwin.network.LoadApiStatus
import com.arthurtang.androidapppractice_winwin.network.WinWinApi
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.lang.Exception

class MainViewModel: ViewModel() {

    private val _contentData = MutableLiveData<List<ContentData?>?>()
    val contentData: LiveData<List<ContentData?>?>
        get() = _contentData

    private val _content = MutableLiveData<ContentData?>()
    val content: LiveData<ContentData?>
        get() = _content

    private val _status = MutableLiveData<LoadApiStatus>()
    val status: LiveData<LoadApiStatus>
        get() = _status

    private var viewModelJob = Job()

    init {
        getData()
    }

    private fun getData() {
        viewModelScope.launch {
            try {
                _contentData.value = WinWinApi.retrofitService.getData()
                _status.value = LoadApiStatus.DONE
                Log.i("getData", "mainViewModel launch")
            } catch (e: Exception) {
                _contentData.value = null
                _status.value = LoadApiStatus.ERROR
                Log.i("getData_error", "error ${e.message}")
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}