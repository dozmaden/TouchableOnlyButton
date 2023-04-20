package com.example.testsandbox

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import com.example.testsandbox.ui.theme.TestSandboxTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestSandboxTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        TouchableOnlyButton()
    }
}

@Composable
fun TouchableOnlyButton() {

    val interactionSource = remember { MutableInteractionSource() }
    val pressedState by interactionSource.collectIsPressedAsState()
    val showDialog = remember { mutableStateOf(false) }

    Button(
        onClick = {
            Log.d("TouchableOnlyButton", "onClick")
            // Check if button was clicked by genuine touch interaction, rather than Tap -> Enter
            if (pressedState) {
                Log.d("TouchableOnlyButton", "pressedState")
                showDialog.value = true
            }
        },
        modifier = Modifier.testTag("button"),
        interactionSource = interactionSource,
    ) {
        Text(text = "Click me!")
        if (showDialog.value) {
            AlertDialog(
                modifier = Modifier.testTag("alert"),
                text = { Text("Clicked") },
                onDismissRequest = { showDialog.value = false },
                buttons = { }
            )
        }
    }
}
