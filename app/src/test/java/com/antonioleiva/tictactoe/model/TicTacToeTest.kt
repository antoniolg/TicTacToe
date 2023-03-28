package com.antonioleiva.tictactoe.model

import org.junit.Assert.*
import org.junit.Test

class TicTacToeTest {

    @Test
    fun `when X plays in the top left corner, then X is in the top left corner`() {
        val ticTacToe = TicTacToe().move(0, 0)
        assertEquals('X', ticTacToe.board[0][0])
    }

    @Test
    fun `when X plays in the top left corner and O plays in the top right corner, then O is in the top right corner`() {
        val ticTacToe = TicTacToe().move(0, 0).move(0, 2)
        assertEquals('O', ticTacToe.board[0][2])
    }

    @Test
    fun `when X plays in the top left corner and O plays in the top right corner and X plays in the top middle, then X is in the top middle`() {
        val ticTacToe = TicTacToe().move(0, 0).move(0, 2).move(0, 1)
        assertEquals('X', ticTacToe.board[0][1])
    }

    @Test
    fun `when X plays in the top left corner and O plays in the top right corner and X plays in the top middle and O plays in the middle left, then O is in the middle left`() {
        val ticTacToe = TicTacToe().move(0, 0).move(0, 2).move(0, 1).move(1, 0)
        assertEquals('O', ticTacToe.board[1][0])
    }

    @Test
    fun `when X plays in the top left corner and O plays in the top right corner and X plays in the top middle and O plays in the middle left and X plays in the top right, then X is the winner`() {
        val ticTacToe = TicTacToe().move(0, 0).move(0, 2).move(0, 1).move(1, 0).move(0, 2)
        assertEquals(Winner.X, ticTacToe.findWinner())
    }

}