package com.sameh.taskskmp.utils

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.jdbc.sqlite.JdbcSqliteDriver
import com.sameh.taskskmp.db.TasksDatabase

actual class DatabaseDriverFactory {

    actual fun create(): SqlDriver {
        val driver: SqlDriver = JdbcSqliteDriver(JdbcSqliteDriver.IN_MEMORY)
        TasksDatabase.Schema.create(driver)
        return driver
    }
}