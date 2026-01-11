package com.yassinelakdimi.studybuddy.ui.screens.timer

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TimerScreen(
    viewModel: TimerViewModel,
    onBack: () -> Unit
) {
    val state by viewModel.uiState.collectAsState()

    // Snackbar state
    val snackbarHostState = remember { SnackbarHostState() }

    // Listen to one-time UI events from the ViewModel
    LaunchedEffect(Unit) {
        viewModel.eventFlow.collect { event ->
            when (event) {
                is TimerUiEvent.SessionSaved -> {
                    snackbarHostState.showSnackbar(
                        message = "Session saved 🎉"
                    )
                }
            }
        }
    }

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) },
        topBar = {
            TopAppBar(
                title = { Text("Timer Pomodoro") },
                navigationIcon = {
                    TextButton(onClick = onBack) { Text("Back") }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            val minutes = state.remainingSeconds / 60
            val seconds = state.remainingSeconds % 60

            state.taskTitle?.let { title ->
                Text(
                    text = "Task: $title",
                    style = MaterialTheme.typography.titleMedium
                )
            }


            Text(
                text = String.format("%02d:%02d", minutes, seconds),

                style = MaterialTheme.typography.displayMedium
            )


            Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                Button(onClick = { viewModel.start() }, enabled = !state.isRunning) {
                    Text("Start")
                }
                Button(onClick = { viewModel.pause() }, enabled = state.isRunning) {
                    Text("Pause")
                }
                OutlinedButton(onClick = { viewModel.reset() }) {
                    Text("Reset")
                }
            }

            Text(
                text = "When the timer finishes, the session is automatically saved.",
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}
