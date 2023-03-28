package com.antonioleiva.tictactoe.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.antonioleiva.tictactoe.ui.home.AppViewModel
import com.antonioleiva.tictactoe.ui.home.HomeScreen

@Composable
fun App() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        val viewModel = remember { AppViewModel() }
        HomeScreen(viewModel)
    }
}