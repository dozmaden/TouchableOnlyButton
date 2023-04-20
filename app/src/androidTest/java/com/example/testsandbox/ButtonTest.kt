package com.example.testsandbox

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import com.example.testsandbox.ui.theme.TestSandboxTheme
import org.junit.Rule
import org.junit.Test

class ButtonTest {

    @get: Rule
    val composeTestRule = createComposeRule()

    @Test
    fun myTest() {
        // Start the app
        composeTestRule.setContent {
            TestSandboxTheme {
                MainScreen()
            }
        }
        composeTestRule.onNodeWithTag("button").performClick()
        composeTestRule.onNodeWithTag("alert").assertExists()
    }
}