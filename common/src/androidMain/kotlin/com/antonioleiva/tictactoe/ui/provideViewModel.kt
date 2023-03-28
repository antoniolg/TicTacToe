package com.antonioleiva.tictactoe.ui

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.antonioleiva.tictactoe.ui.home.AacAppViewModel
import com.antonioleiva.tictactoe.ui.home.AppViewModel

@Composable
actual fun provideViewModel(): AppViewModel = viewModel { AacAppViewModel() }