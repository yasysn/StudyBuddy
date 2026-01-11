package com.yassinelakdimi.studybuddy.ui.screens.progress

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.yassinelakdimi.studybuddy.data.local.entity.StudySessionEntity
import com.yassinelakdimi.studybuddy.ui.screens.progress.SessionUiModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProgressScreen(
    viewModel: ProgressViewModel,
    onBack: () -> Unit
) {
    val state by viewModel.uiState.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Progression") },
                navigationIcon = {
                    TextButton(onClick = onBack) { Text("Retour") }
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
            Card(modifier = Modifier.fillMaxWidth()) {
                Column(modifier = Modifier.padding(12.dp)) {
                    Text("Total étudié", style = MaterialTheme.typography.titleMedium)
                    Text("${state.totalMinutes} minutes", style = MaterialTheme.typography.headlineSmall)
                    Text("Sessions: ${state.sessions.size}")
                }
            }

            Text("Historique des sessions", style = MaterialTheme.typography.titleMedium)

            LazyColumn {
                items(state.sessions.reversed()) { session ->
                    SessionRow(session)
                    Spacer(Modifier.height(8.dp))
                }
            }
        }
    }
}

@Composable

private fun SessionRow(session: SessionUiModel) {
    Card(modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(12.dp)) {
            Text("Duration: ${session.durationMinutes} min")

            Text(
                text = session.taskTitle?.let { "Task: $it" } ?: "Task: Free study",
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

