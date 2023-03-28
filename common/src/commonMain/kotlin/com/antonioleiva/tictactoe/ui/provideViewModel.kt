package com.antonioleiva.tictactoe.ui

import androidx.compose.runtime.Composable
import com.antonioleiva.tictactoe.ui.home.AppViewModel

@Composable
expect fun provideViewModel(): AppViewModel