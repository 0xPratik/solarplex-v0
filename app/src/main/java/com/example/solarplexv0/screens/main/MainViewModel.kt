package com.example.solarplexv0.screens.main

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.solarplexv0.model.Forum
import com.example.solarplexv0.model.ForumItem
import com.example.solarplexv0.network.SolarplexAPI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val solarplexApi : SolarplexAPI) : ViewModel() {

    private val _forumItems = MutableStateFlow<List<ForumItem>>(emptyArray<ForumItem>().toList())
    val forumItems = _forumItems.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val response = try {
                solarplexApi.getForum()
            }catch (e: Exception)  {
                Log.d("ERROR","Something Went Wrong")
            }

            Log.d("RESPONSE",response.toString())

        }
    }



}