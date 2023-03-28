package com.antonioleiva.tictactoe.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.antonioleiva.tictactoe.ui.home.GenericAppViewModel
import com.antonioleiva.tictactoe.ui.home.AppViewModel

@Composable
actual fun provideViewModel(): AppViewModel = remember { GenericAppViewModel() }