package com.yassinelakdimi.studybuddy.ui.screens.progress

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yassinelakdimi.studybuddy.data.local.entity.StudySessionEntity
import com.yassinelakdimi.studybuddy.data.repository.StudyRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

data class ProgressUiState(
    val sessions: List<SessionUiModel> = emptyList(),
    val totalMinutes: Int = 0
)


class ProgressViewModel(
    repository: StudyRepository
) : ViewModel() {

    val uiState: StateFlow<ProgressUiState> =
        repository.getAllSessions()
            .map { sessions ->
                val sessionUiModels = sessions.map { session ->
                    val title = session.taskId?.let { taskId ->
                        repository.getTaskById(taskId)?.title
                    }

                    SessionUiModel(
                        durationMinutes = session.durationMinutes,
                        taskTitle = title
                    )
                }

                ProgressUiState(
                    sessions = sessionUiModels,
                    totalMinutes = sessions.sumOf { it.durationMinutes }
                )
            }
            .stateIn(
                viewModelScope,
                SharingStarted.WhileSubscribed(5000),
                ProgressUiState()
            )
}
