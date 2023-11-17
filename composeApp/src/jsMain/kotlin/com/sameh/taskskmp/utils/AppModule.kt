package com.sameh.taskskmp.utils

import com.sameh.taskskmp.data.repo.TaskRepo
import com.sameh.taskskmp.db.TasksDatabase

actual class AppModule {

    actual val taskRepo: TaskRepo by lazy {
        TaskRepo(
            db = TasksDatabase(DatabaseDriverFactory(TasksDatabase.Schema).create())
        )
    }
}