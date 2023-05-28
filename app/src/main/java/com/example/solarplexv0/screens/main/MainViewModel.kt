package com.example.solarplexv0.screens.main

import androidx.lifecycle.ViewModel
import com.example.solarplexv0.network.SolarplexAPI
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val solarplexApi : SolarplexAPI) : ViewModel() {



}