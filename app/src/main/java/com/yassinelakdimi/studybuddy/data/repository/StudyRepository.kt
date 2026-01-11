package com.yassinelakdimi.studybuddy.data.repository

import com.yassinelakdimi.studybuddy.data.local.entity.StudySessionEntity
import com.yassinelakdimi.studybuddy.data.local.entity.TaskEntity
import kotlinx.coroutines.flow.Flow

interface StudyRepository {
    fun getAllTasks(): Flow<List<TaskEntity>>
    suspend fun addTask(task: TaskEntity)
    suspend fun updateTask(task: TaskEntity)
    suspend fun deleteTask(task: TaskEntity)

    suspend fun logStudySession(session: StudySessionEntity)
    fun getAllSessions(): Flow<List<StudySessionEntity>>

}
