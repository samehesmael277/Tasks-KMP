package com.sameh.taskskmp.utils

import com.sameh.taskskmp.data.repo.TaskRepo
import com.sameh.taskskmp.db.TasksDatabase

actual class AppModule {

    actual val taskRepo: TaskRepo by lazy {
        TaskRepo(
            db = TasksDatabase(DatabaseDriverFactory().create())
        )
    }

//    actual fun provideTaskRepo(): TaskRepo {
//        return TaskRepo(
//            db = TasksDatabase(DBDriverFactory().create())
//        )
//    }
}