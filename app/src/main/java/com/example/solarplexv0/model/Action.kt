package com.example.solarplexv0.model

data class Action(
    val crud: Int,
    val params: Params,
    val type: Int
)