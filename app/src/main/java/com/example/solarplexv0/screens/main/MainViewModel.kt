package com.example.solarplexv0.screens.main

import android.net.Uri
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.solarplexv0.R
import com.example.solarplexv0.model.ForumItem
import com.example.solarplexv0.network.SolarplexAPI
import com.solana.mobilewalletadapter.clientlib.ActivityResultSender
import com.solana.mobilewalletadapter.clientlib.MobileWalletAdapter
import com.solana.mobilewalletadapter.clientlib.RpcCluster
import com.solana.mobilewalletadapter.clientlib.TransactionResult
import com.solana.core.PublicKey
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

data class WalletViewState(
    val userAddress: String = "",
    val authToken: String = "",
)
@HiltViewModel
class MainViewModel @Inject constructor(
    private val solarplexApi : SolarplexAPI,
    private val walletadapter: MobileWalletAdapter
    ) : ViewModel() {

    private val _forumItems = MutableStateFlow<List<ForumItem>>(emptyArray<ForumItem>().toList())
    val forumItems = _forumItems.asStateFlow()

    private val _walletState = MutableStateFlow(WalletViewState())

    val walletState = _walletState.asStateFlow()

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

    fun connectWallet(activityResultSender: ActivityResultSender){

       viewModelScope.launch {
           val result = walletadapter.transact(activityResultSender) {
                    authorize(
                        identityUri = Uri.parse("https://solarplex.xyz"),
                        identityName = "Solarplex",
                        iconUri = Uri.parse(R.drawable.solarplex_logo.toString()),
                        rpcCluster = RpcCluster.Devnet
                    )

           }

           when(result) {
               is TransactionResult.Success -> {
                   Log.d("Connected", PublicKey(result.payload.publicKey).toBase58())

                   _walletState.value = WalletViewState(
                       userAddress = PublicKey(result.payload.publicKey).toBase58(),
                       authToken = result.payload.authToken)
               }
               is TransactionResult.NoWalletFound -> {
                   Log.d("Err","No Wallet Found")
               }
               is TransactionResult.Failure -> {
                   /** not gonna do anything here now **/
               }
           }
       }
    }





}