package com.yassinelakdimi.studybuddy

import android.content.Context
import androidx.room.Room
import com.yassinelakdimi.studybuddy.data.local.AppDatabase
import com.yassinelakdimi.studybuddy.data.repository.StudyRepository
import com.yassinelakdimi.studybuddy.data.repository.StudyRepositoryImpl

class AppContainer(context: Context) {

    private val db: AppDatabase = Room.databaseBuilder(
        context,
        AppDatabase::class.java,
        "studybuddy_db"
    ).build()

    val repository: StudyRepository = StudyRepositoryImpl(
        taskDao = db.taskDao(),
        studySessionDao = db.studySessionDao()
    )
}
