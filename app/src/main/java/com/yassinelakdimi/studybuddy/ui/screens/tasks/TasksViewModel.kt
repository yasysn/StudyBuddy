package com.yassinelakdimi.studybuddy.ui.screens.tasks

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yassinelakdimi.studybuddy.data.local.entity.TaskEntity
import com.yassinelakdimi.studybuddy.data.repository.StudyRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

data class TasksUiState(
    val tasks: List<TaskEntity> = emptyList()
)

class TasksViewModel(
    private val repository: StudyRepository
) : ViewModel() {

    val uiState: StateFlow<TasksUiState> =
        repository.getAllTasks()
            .map { TasksUiState(tasks = it) }
            .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), TasksUiState())

    
}
