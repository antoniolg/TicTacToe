package com.antonioleiva.tictactoe.ui.home

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.antonioleiva.tictactoe.model.Winner

@Composable
fun HomeScreen(vm: AppViewModel) {
    when (vm.state.gameState) {
        is GameState.NotStarted -> NotStarted(vm::startGame)
        else -> Game(vm.state, vm::move, vm::startGame)
    }
}

@Composable
fun NotStarted(onStartClick: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = "Tic Tac Toe",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(16.dp)
        )
        Button(onClick = onStartClick) {
            Text("Click to Start")
        }
    }
}

@Composable
fun Game(state: UiState, onMove: (row: Int, column: Int) -> Unit, onRestartClick: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Board(state.ticTacToe.board, onMove, enabled = state.gameState is GameState.InProgress)

        when (state.gameState) {
            is GameState.InProgress -> {
                CurrentPlayer(state.ticTacToe.currentPlayer)
            }

            is GameState.Finished -> {
                Winner(state.gameState.winner, onRestartClick)
            }

            else -> {
                // Do nothing
            }
        }
    }
}

@Composable
fun Board(board: List<List<Char>>, onMove: (row: Int, column: Int) -> Unit, enabled: Boolean) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(64.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        board.forEachIndexed { rowIndex, row ->
            Row {
                row.forEachIndexed { columnIndex, cell ->
                    Cell(
                        cell = cell,
                        onClick = { onMove(rowIndex, columnIndex) },
                        enabled = enabled
                    )
                }
            }
        }
    }
}

@Composable
fun CurrentPlayer(currentPlayer: Char) {
    Text(
        text = "Current player: $currentPlayer",
        style = MaterialTheme.typography.headlineLarge
    )
}

@Composable
fun RowScope.Cell(cell: Char, onClick: () -> Unit, enabled: Boolean) {
    Box(
        modifier = Modifier
            .clickable(onClick = onClick, enabled = cell == ' ' && enabled)
            .border(1.dp, color = MaterialTheme.colorScheme.onBackground)
            .weight(1f)
            .aspectRatio(1f),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = cell.toString(),
            style = MaterialTheme.typography.displayLarge
        )
    }
}

@Composable
fun Winner(winner: Winner, onRestartClick: () -> Unit) {
    Text(
        text = "Winner: $winner",
        style = MaterialTheme.typography.headlineLarge,
        modifier = Modifier.padding(16.dp)
    )
    Button(onClick = onRestartClick) {
        Text(text = "Play again")
    }
}
