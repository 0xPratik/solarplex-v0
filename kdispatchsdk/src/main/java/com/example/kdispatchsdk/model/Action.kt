package com.example.kdispatchsdk.model

data class Action(
    val crud: Int,
    val params: Params,
    val type: Int
)