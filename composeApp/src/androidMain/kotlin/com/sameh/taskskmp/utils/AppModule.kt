package com.sameh.taskskmp.utils

import android.content.Context
import com.sameh.taskskmp.data.repo.TaskRepo
import com.sameh.taskskmp.db.TasksDatabase

actual class AppModule(context: Context) {

    actual val taskRepo: TaskRepo by lazy {
        TaskRepo(
            db = TasksDatabase(
                DatabaseDriverFactory(context = context).create()
            )
        )
    }

//    actual fun provideTaskRepo(): TaskRepo {
//        return TaskRepo(
//            db = TasksDatabase(DBDriverFactory(context).create())
//        )
//    }
}