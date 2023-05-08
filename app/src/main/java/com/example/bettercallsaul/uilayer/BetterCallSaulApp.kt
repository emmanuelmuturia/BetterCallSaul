package com.example.bettercallsaul.uilayer

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Refresh
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.bettercallsaul.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BetterCallSaulApp(betterCallSaulViewModel: BetterCallSaulViewModel = hiltViewModel()) {

    val betterCallSaulState by betterCallSaulViewModel.betterCallSaulUiState.collectAsState()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { BetterCallSaulAppBar() },
        /*floatingActionButton = {
            FloatingActionButton(onClick = { theSimpsonsViewModel.getTheSimpsonsQuotes() }, containerColor = Color.Yellow) {
                Icon(imageVector = Icons.Rounded.Refresh, contentDescription = "Refresh")
            }
        }*/
    ) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            color = Color.DarkGray
        ) {
            HomeScreen(betterCallSaulState = betterCallSaulState)
        }
    }

}


@Composable
fun BetterCallSaulAppBar() {
    Row(
        modifier = Modifier
            .background(color = MaterialTheme.colorScheme.background)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(painter = painterResource(id = R.drawable.saul), contentDescription = null, modifier = Modifier
            .size(91.dp)
            .padding(7.dp))
        Spacer(modifier = Modifier.width(width = 49.dp))
        Text(text = stringResource(id = R.string.app_name), style = MaterialTheme.typography.titleLarge, fontSize = 21.sp)
    }
}