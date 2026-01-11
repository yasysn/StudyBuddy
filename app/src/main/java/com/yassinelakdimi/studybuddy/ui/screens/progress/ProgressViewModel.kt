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
    val sessions: List<StudySessionEntity> = emptyList(),
    val totalMinutes: Int = 0
)

class ProgressViewModel(
    repository: StudyRepository
) : ViewModel() {

    val uiState: StateFlow<ProgressUiState> =
        repository.getAllSessions()
            .map { sessions ->
                ProgressUiState(
                    sessions = sessions,
                    totalMinutes = sessions.sumOf { it.durationMinutes }
                )
            }
            .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), ProgressUiState())
}
