package com.sameh.taskskmp.utils

import com.sameh.taskskmp.data.repo.TaskRepo

expect class AppModule {

    val taskRepo: TaskRepo
}