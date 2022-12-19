package com.antonioleiva.tictactoe.model

data class TicTacToe(
    val board: List<List<Char>> = List(3) { List(3) { ' ' } },
    val currentPlayer: Char = 'X'
) {
    fun move(moveRow: Int, moveColumn: Int): TicTacToe {
        val newBoard = board.mapIndexed { rowIndex, row ->
            row.mapIndexed { columnIndex, cell ->
                if (rowIndex == moveRow && columnIndex == moveColumn) currentPlayer else cell
            }
        }
        return TicTacToe(newBoard, nextPlayer())
    }

    private fun nextPlayer() = if (currentPlayer == 'X') 'O' else 'X'
}
