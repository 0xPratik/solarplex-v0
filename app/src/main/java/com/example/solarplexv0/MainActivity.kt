package com.example.solarplexv0

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.solarplexv0.nav.AppNavigation
import com.example.solarplexv0.ui.theme.Solarplexv0Theme
import com.solana.mobilewalletadapter.clientlib.ActivityResultSender
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityResultSender = ActivityResultSender(this)
        setContent {
          SolarplexApp(activityResultSender = activityResultSender)
        }
    }
}

@Composable
fun SolarplexApp (activityResultSender: ActivityResultSender) {
    Solarplexv0Theme {
        AppNavigation(activityResultSender = activityResultSender)
    }
}