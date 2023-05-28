package com.example.solarplexv0.model

data class ForumItem(
    val action: Action,
    val actionId: String,
    val actions: Int,
    val address: String,
    val admins: Int,
    val block: Int,
    val blockOrder: String,
    val body: String,
    val chainId: Int,
    val children: Int,
    val creatorId: String,
    val deletedBy: String,
    val depth: Int,
    val did: String,
    val downVotes: Int,
    val errors: List<Any>,
    val expires: Int,
    val funds: Funds,
    val hash: String,
    val id: String,
    val image: String,
    val media: List<Any>,
    val mentions: List<Any>,
    val name: String,
    val nonce: String,
    val originalTargetId: String,
    val parentId: String,
    val pendingActionId: String,
    val pendingId: String,
    val pin: Boolean,
    val pins: List<Any>,
    val preferWalletPopups: Boolean,
    val profileIds: List<Any>,
    val programId: String,
    val proxyKeys: ProxyKeys,
    val proxyWallet: String,
    val score: Int,
    val signedTxn: Any,
    val status: Int,
    val subtitle: String,
    val tags: List<Any>,
    val time: Int,
    val title: String,
    val twitter: String,
    val twitterUserId: String,
    val txId: String,
    val txn: Int,
    val upVotes: Int,
    val updateTime: Int,
    val updatedBlockOrder: String,
    val url: String,
    val wallet: String
)