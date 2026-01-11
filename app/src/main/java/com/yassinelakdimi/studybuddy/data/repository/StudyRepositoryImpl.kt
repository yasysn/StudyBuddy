package com.yassinelakdimi.studybuddy.data.repository

import com.yassinelakdimi.studybuddy.data.local.dao.StudySessionDao
import com.yassinelakdimi.studybuddy.data.local.dao.TaskDao
import com.yassinelakdimi.studybuddy.data.local.entity.StudySessionEntity
import com.yassinelakdimi.studybuddy.data.local.entity.TaskEntity
import kotlinx.coroutines.flow.Flow

class StudyRepositoryImpl(
    private val taskDao: TaskDao,
    private val studySessionDao: StudySessionDao
) : StudyRepository {

    override fun getAllTasks(): Flow<List<TaskEntity>> = taskDao.getAllTasks()

    override suspend fun addTask(task: TaskEntity) = taskDao.insert(task)

    override suspend fun updateTask(task: TaskEntity) = taskDao.update(task)

    override suspend fun deleteTask(task: TaskEntity) = taskDao.delete(task)

    override suspend fun logStudySession(session: StudySessionEntity) =
        studySessionDao.insert(session)

    override fun getAllSessions(): Flow<List<StudySessionEntity>> =
        studySessionDao.getAllSessions()

    override suspend fun getTaskById(taskId: Int): TaskEntity? =
        taskDao.getTaskById(taskId)


}
