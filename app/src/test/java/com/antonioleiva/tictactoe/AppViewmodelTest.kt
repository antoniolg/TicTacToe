package com.antonioleiva.tictactoe

import com.antonioleiva.tictactoe.model.Winner
import com.antonioleiva.tictactoe.ui.home.AppViewModel
import com.antonioleiva.tictactoe.ui.home.GameState
import org.junit.Assert.assertEquals
import org.junit.Test

class AppViewModelTest {

    @Test
    fun `when game is not started, and startGame is called, then game is in progress`() {
        val viewModel = AppViewModel()
        viewModel.startGame()
        assertEquals(GameState.InProgress, viewModel.state.gameState)
    }

    @Test
    fun `when X plays in the top left corner, then X is in the top left corner`() {
        val appViewModel = AppViewModel()
        appViewModel.move(0, 0)
        assertEquals('X', appViewModel.state.ticTacToe.board[0][0])
    }

    @Test
    fun `when X plays in the top left corner and O plays in the top right corner, then O is in the top right corner`() {
        val appViewModel = AppViewModel()
        appViewModel.move(0, 0)
        appViewModel.move(0, 2)
        assertEquals('O', appViewModel.state.ticTacToe.board[0][2])
    }

    @Test
    fun `when X plays in the top left corner and O plays in the top right corner and X plays in the top middle, then X is in the top middle`() {
        val appViewModel = AppViewModel()
        appViewModel.move(0, 0)
        appViewModel.move(0, 2)
        appViewModel.move(0, 1)
        assertEquals('X', appViewModel.state.ticTacToe.board[0][1])
    }

    @Test
    fun `when X plays in the top left corner and O plays in the top right corner and X plays in the top middle and O plays in the middle left, then O is in the middle left`() {
        val appViewModel = AppViewModel()
        appViewModel.move(0, 0)
        appViewModel.move(0, 2)
        appViewModel.move(0, 1)
        appViewModel.move(1, 0)
        assertEquals('O', appViewModel.state.ticTacToe.board[1][0])
    }

    @Test
    fun `when X plays in the top left corner and O plays in the top right corner and X plays in the top middle and O plays in the middle left and X plays in the top right, then X is the winner`() {
        val appViewModel = AppViewModel()
        appViewModel.move(0, 0)
        appViewModel.move(0, 2)
        appViewModel.move(0, 1)
        appViewModel.move(1, 0)
        appViewModel.move(0, 2)
        assertEquals(GameState.Finished(Winner.X), appViewModel.state.gameState)
    }

    @Test
    fun `when game is finished, and startGame is called, then game is in progress`() {
        val appViewModel = AppViewModel()
        appViewModel.move(0, 0)
        appViewModel.move(0, 2)
        appViewModel.move(0, 1)
        appViewModel.move(1, 0)
        appViewModel.move(0, 2)
        appViewModel.startGame()
        assertEquals(GameState.InProgress, appViewModel.state.gameState)
    }
}