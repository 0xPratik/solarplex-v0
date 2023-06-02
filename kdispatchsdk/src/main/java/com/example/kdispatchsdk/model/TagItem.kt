package com.example.kdispatchsdk.model

data class TagItem(
    val actionId: String,
    val blockOrder: String,
    val chainId: Int,
    val creatorId: String,
    val deletedBy: String,
    val id: String,
    val name: String,
    val parentId: String,
    val pendingActionId: String,
    val status: Int,
    val tags: List<Any>,
    val txId: String,
    val updatedBlockOrder: String,
    val wallet: String
)