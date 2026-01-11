package com.yassinelakdimi.studybuddy.ui.screens.tasks

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.yassinelakdimi.studybuddy.data.local.entity.TaskEntity
import com.yassinelakdimi.studybuddy.ui.utils.MotivationalQuotes

@Composable
fun TasksScreen(
    viewModel: TasksViewModel,
    onAddClick: () -> Unit,
    onTimerClick: () -> Unit,
    onProgressClick: () -> Unit,
    onStartTask: (Int) -> Unit

)
 {
    val state by viewModel.uiState.collectAsState()

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = onAddClick) {
                Text("+")
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text("Mes tâches", style = MaterialTheme.typography.headlineSmall)
            Button(onClick = { onTimerClick() }) {
                Text("Ouvrir Timer")
            }
            Button(onClick = { onProgressClick() }) {
                Text("Voir Progression")
            }

            Text(
                text = MotivationalQuotes.getDailyQuote(),
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.primary
            )

            Spacer(Modifier.height(16.dp))





            Spacer(Modifier.height(12.dp))

            LazyColumn {
                items(state.tasks) { task ->
                    TaskRow(task, onStartTask)
                    Spacer(Modifier.height(8.dp))
                }
            }
        }
    }
}

@Composable
private fun TaskRow(task: TaskEntity, onStartTask: (Int) -> Unit) {
    Card(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier.padding(12.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(task.title, style = MaterialTheme.typography.titleMedium)
                Text("Priorité: ${task.priority}", style = MaterialTheme.typography.bodyMedium)
            }
            Spacer(Modifier.width(12.dp))
            Button(onClick = { onStartTask(task.id) }) {
                Text("Démarrer")
            }
        }
    }
}
