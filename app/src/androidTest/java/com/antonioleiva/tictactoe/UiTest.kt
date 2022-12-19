package com.antonioleiva.tictactoe

import androidx.compose.foundation.layout.Row
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.antonioleiva.tictactoe.ui.screen.home.Cell
import org.junit.Assert
import org.junit.Rule
import org.junit.Test

class UiTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun whenCellIsEnabled_thenOnClickIsCalled(): Unit = with(composeTestRule) {
        var onClickCalled = false
        setContent {
            Row {
                Cell(
                    cell = ' ',
                    enabled = true,
                    onClick = { onClickCalled = true }
                )
            }
        }
        onNodeWithText(" ").performClick()
        Assert.assertTrue(onClickCalled)
    }

    @Test
    fun whenCellIsDisabled_thenOnClickIsNotCalled(): Unit = with(composeTestRule) {
        var onClickCalled = false
        setContent {
            Row {
                Cell(
                    cell = ' ',
                    enabled = false,
                    onClick = { onClickCalled = true }
                )
            }
        }
        onNodeWithText(" ").performClick()
        Assert.assertFalse(onClickCalled)
    }

    @Test
    fun whenCellIsEnabledAndFilled_thenOnClickIsNotCalled(): Unit = with(composeTestRule) {
        var onClickCalled = false
        setContent {
            Row {
                Cell(
                    cell = 'X',
                    enabled = true,
                    onClick = { onClickCalled = true }
                )
            }
        }
        onNodeWithText("X").performClick()
        Assert.assertFalse(onClickCalled)
    }
}