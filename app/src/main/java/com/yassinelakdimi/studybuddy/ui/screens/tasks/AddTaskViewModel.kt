package com.yassinelakdimi.studybuddy.ui.screens.tasks

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yassinelakdimi.studybuddy.data.local.entity.TaskEntity
import com.yassinelakdimi.studybuddy.data.repository.StudyRepository
import kotlinx.coroutines.launch

class AddTaskViewModel(
    private val repository: StudyRepository
) : ViewModel() {

    fun addTask(
        title: String,
        priority: Int
    ) {
        if (title.isBlank()) return

        viewModelScope.launch {
            repository.addTask(
                TaskEntity(
                    title = title,
                    subjectId = 1,
                    priority = priority
                )
            )
        }
    }
}
