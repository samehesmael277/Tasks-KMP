package com.sameh.taskskmp.data.model

import db.TaskTable

data class Task(
    val id: Long? = null,
    val title: String
)

// mapper
fun TaskTable.toTask(): Task {
    return Task(
        id = id,
        title = title
    )
}