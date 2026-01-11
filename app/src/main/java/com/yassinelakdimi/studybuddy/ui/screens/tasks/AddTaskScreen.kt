package com.yassinelakdimi.studybuddy.ui.screens.tasks

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.mutableIntStateOf



@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun AddTaskScreen(
    viewModel: AddTaskViewModel,
    onTaskAdded: () -> Unit
)
 {
    var title by remember { mutableStateOf("") }
    var priority by remember { mutableIntStateOf(1) }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Ajouter une tâche") })
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
        ) {
            OutlinedTextField(
                value = title,
                onValueChange = { title = it },
                label = { Text("Titre de la tâche") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(Modifier.height(16.dp))

            Text("Priorité")

            Slider(
                value = priority.toFloat(),
                onValueChange = { priority = it.toInt() },
                valueRange = 1f..3f,
                steps = 1
            )

            Spacer(Modifier.height(24.dp))

            Button(
                onClick = {
                    viewModel.addTask(title, priority)
                    onTaskAdded()
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Ajouter")
            }
        }
    }
}
