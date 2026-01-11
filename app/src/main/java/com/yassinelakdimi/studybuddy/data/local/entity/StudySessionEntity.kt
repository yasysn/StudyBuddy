package com.yassinelakdimi.studybuddy.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "study_sessions")
data class StudySessionEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val subjectId: Int,
    val taskId: Int?,
    val durationMinutes: Int,
    val timestamp: Long
)
