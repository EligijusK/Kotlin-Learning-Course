package com.example.red30.compose

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.red30.data.ConferenceRepository
import com.example.sample.SampleRepository
import kotlinx.coroutines.launch

private const val TAG = "MainViewModel"

class MainViewModel(
    private val conferenceRepository: ConferenceRepository
): ViewModel() {

    init {
        viewModelScope.launch {
            val sessionInfos =  conferenceRepository.loadConferenceInfo()
            Log.i(TAG, "initialized: $sessionInfos")
        }
    }

    fun doSomething() {
        
    }
}