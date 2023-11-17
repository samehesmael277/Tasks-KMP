package com.sameh.taskskmp.utils

import android.content.Context
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.sameh.taskskmp.db.TasksDatabase

actual class DatabaseDriverFactory(private val context: Context) {

    actual fun create(): SqlDriver {
        return AndroidSqliteDriver(TasksDatabase.Schema, context, "test.db")
    }
}