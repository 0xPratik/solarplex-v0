package com.example.solarplexv0.screens
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.solarplexv0.screens.main.MainViewModel
import com.solana.mobilewalletadapter.clientlib.ActivityResultSender

@Composable
fun MainScreen(mainViewModel: MainViewModel,activityResultSender: ActivityResultSender) {
    Column(modifier = Modifier.fillMaxSize()) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.7f), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center){
            Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(id = com.example.solarplexv0.R.drawable.solarplex_logo),
                    contentDescription = "Solarplex Logo",
                    modifier = Modifier.size(100.dp)
                )
                Text(text = "Solarplex", fontSize = 30.sp, fontWeight = FontWeight.SemiBold)
            }
        }
        Row(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.3f),verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center){
            Button(onClick = { mainViewModel.connectWallet(activityResultSender) },modifier = Modifier.width(260.dp)) {
                Text(text = "Connect Wallet",modifier = Modifier.padding(8.dp))
            }
        }
    }
}