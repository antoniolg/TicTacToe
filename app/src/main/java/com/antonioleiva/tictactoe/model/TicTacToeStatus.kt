package com.antonioleiva.tictactoe.model

fun TicTacToe.findWinner(): Winner? {
    return when {
        isWinner('X') -> Winner.X
        isWinner('O') -> Winner.O
        isBoardComplete() -> Winner.Draw
        else -> null
    }
}

private fun TicTacToe.isBoardComplete(): Boolean {
    return board.flatten().none { it == ' ' }
}

private fun TicTacToe.isWinner(player: Char): Boolean {
    return board.any { row -> row.all { it == player } } ||
            board[0][0] == player && board[1][1] == player && board[2][2] == player ||
            board[0][2] == player && board[1][1] == player && board[2][0] == player ||
            board[0][0] == player && board[1][0] == player && board[2][0] == player ||
            board[0][1] == player && board[1][1] == player && board[2][1] == player ||
            board[0][2] == player && board[1][2] == player && board[2][2] == player
}
