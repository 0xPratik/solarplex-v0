package com.example.solarplexv0.model

data class PostBoxItem(
    val actionId: String,
    val address: String,
    val blockOrder: String,
    val chainId: Int,
    val creatorId: String,
    val deletedBy: String,
    val did: String,
    val expires: Int,
    val funds: Funds,
    val id: String,
    val image: String,
    val name: String,
    val parentId: String,
    val pendingActionId: String,
    val proxyKeys: ProxyKeys,
    val status: Int,
    val tags: List<Any>,
    val twitter: String,
    val twitterUserId: String,
    val txId: String,
    val updatedBlockOrder: String,
    val wallet: String
)