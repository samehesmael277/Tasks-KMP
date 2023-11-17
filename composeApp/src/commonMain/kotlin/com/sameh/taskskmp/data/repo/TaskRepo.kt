package com.sameh.taskskmp.data.repo

import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import com.sameh.taskskmp.data.model.Task
import com.sameh.taskskmp.data.model.toTask
import com.sameh.taskskmp.db.TasksDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class TaskRepo(
    private val db: TasksDatabase
) {

    private val queries = db.taskQueries

    fun getTasks(): Flow<List<Task>> {
        return queries.getTasks()
            .asFlow()
            .mapToList(Dispatchers.Default) // todo where IO Dispatchers in coroutines
            .map {
                it.map { task ->
                    task.toTask()
                }
            }
    }

    suspend fun addTask(title: String) {
        queries.addTask(null, title)
    }

    suspend fun deleteTask(id: Long) {
        queries.deleteTask(id)
    }
}