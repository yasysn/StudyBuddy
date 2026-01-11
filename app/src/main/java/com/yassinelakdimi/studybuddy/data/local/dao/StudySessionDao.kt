package com.yassinelakdimi.studybuddy.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.yassinelakdimi.studybuddy.data.local.entity.StudySessionEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface StudySessionDao {

    @Insert
    suspend fun insert(session: StudySessionEntity)

    @Query("SELECT * FROM study_sessions")
    fun getAllSessions(): Flow<List<StudySessionEntity>>
}
