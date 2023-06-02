package com.example.kdispatchsdk.model

data class ActionReturnTypeItem(
    val action: Action,
    val actionId: String,
    val block: Int,
    val blockOrder: String,
    val chainId: Int,
    val creatorId: String,
    val deletedBy: String,
    val errors: List<Any>,
    val hash: String,
    val id: String,
    val meta: Meta,
    val nonce: String,
    val originalTargetId: String,
    val parentId: String,
    val pendingActionId: String,
    val pendingId: String,
    val proxyWallet: String,
    val signedTxn: SignedTxn,
    val status: Int,
    val tags: List<Any>,
    val time: Int,
    val txId: String,
    val txn: Int,
    val updatedBlockOrder: String,
    val wallet: String
)