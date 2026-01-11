package com.yassinelakdimi.studybuddy.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.yassinelakdimi.studybuddy.data.local.dao.TaskDao
import com.yassinelakdimi.studybuddy.data.local.dao.StudySessionDao
import com.yassinelakdimi.studybuddy.data.local.entity.TaskEntity
import com.yassinelakdimi.studybuddy.data.local.entity.StudySessionEntity
import com.yassinelakdimi.studybuddy.data.local.entity.SubjectEntity

@Database(
    entities = [TaskEntity::class, StudySessionEntity::class, SubjectEntity::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun taskDao(): TaskDao
    abstract fun studySessionDao(): StudySessionDao
}
