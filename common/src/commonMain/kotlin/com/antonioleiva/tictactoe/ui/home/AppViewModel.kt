package com.antonioleiva.tictactoe.ui.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.antonioleiva.tictactoe.model.TicTacToe
import com.antonioleiva.tictactoe.model.Winner
import com.antonioleiva.tictactoe.model.findWinner

class AppViewModel {

    var state by mutableStateOf(UiState())
        private set

    fun startGame() {
        state = UiState(
            ticTacToe = TicTacToe(),
            gameState = GameState.InProgress
        )
    }

    fun move(row: Int, column: Int) {
        val newTicTacToe = state.ticTacToe.move(row, column)
        state = UiState(
            ticTacToe = newTicTacToe,
            gameState = when (val winner = newTicTacToe.findWinner()) {
                null -> GameState.InProgress
                else -> GameState.Finished(winner)
            }
        )
    }
}

data class UiState(
    val ticTacToe: TicTacToe = TicTacToe(),
    val gameState: GameState = GameState.NotStarted
)

sealed interface GameState {
    object NotStarted : GameState
    object InProgress : GameState
    data class Finished(val winner: Winner) : GameState
}