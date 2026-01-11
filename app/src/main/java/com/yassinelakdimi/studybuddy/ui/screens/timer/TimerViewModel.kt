package com.yassinelakdimi.studybuddy.ui.screens.timer

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yassinelakdimi.studybuddy.data.local.entity.StudySessionEntity
import com.yassinelakdimi.studybuddy.data.repository.StudyRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow

data class TimerUiState(
    val totalSeconds: Int = 60,
    val remainingSeconds: Int = 60,
    val isRunning: Boolean = false
)

sealed class TimerUiEvent {
    object SessionSaved : TimerUiEvent()
}


class TimerViewModel(
    private val repository: StudyRepository
) : ViewModel() {

    private val _eventFlow = MutableSharedFlow<TimerUiEvent>()
    val eventFlow: SharedFlow<TimerUiEvent> = _eventFlow


    private val _uiState = MutableStateFlow(TimerUiState())
    val uiState: StateFlow<TimerUiState> = _uiState

    private var timerJob: Job? = null

    // ✅ DOIT être dans la classe
    private var currentTaskId: Int = -1

    fun setTaskId(taskId: Int) {
        currentTaskId = taskId
    }

    fun start() {
        if (_uiState.value.isRunning) return

        _uiState.update { it.copy(isRunning = true) }

        timerJob = viewModelScope.launch {
            while (_uiState.value.remainingSeconds > 0 && _uiState.value.isRunning) {
                delay(1000)
                _uiState.update { s -> s.copy(remainingSeconds = s.remainingSeconds - 1) }
            }

            if (_uiState.value.remainingSeconds == 0) {
                _uiState.update { it.copy(isRunning = false) }
                logSession()

            }
        }
    }

    fun pause() {
        _uiState.update { it.copy(isRunning = false) }
        timerJob?.cancel()
        timerJob = null
    }

    fun reset() {
        pause()
        _uiState.update { it.copy(remainingSeconds = it.totalSeconds) }
    }

    private fun logSession() {
        viewModelScope.launch {
            val minutes = maxOf(1, _uiState.value.totalSeconds / 60)
            val taskIdOrNull = currentTaskId.takeIf { it != -1 }

            repository.logStudySession(
                StudySessionEntity(
                    subjectId = 1,
                    taskId = taskIdOrNull,
                    durationMinutes = minutes,
                    timestamp = System.currentTimeMillis()
                )
            )

            // Notify UI that the session has been saved
            _eventFlow.emit(TimerUiEvent.SessionSaved)
        }
    }

}
