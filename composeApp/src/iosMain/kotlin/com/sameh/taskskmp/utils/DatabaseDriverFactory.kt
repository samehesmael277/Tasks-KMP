package com.sameh.taskskmp.utils

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import com.sameh.taskskmp.db.TasksDatabase

actual class DatabaseDriverFactory {

    actual fun create(): SqlDriver {
        return NativeSqliteDriver(TasksDatabase.Schema, "test.db")
    }
}