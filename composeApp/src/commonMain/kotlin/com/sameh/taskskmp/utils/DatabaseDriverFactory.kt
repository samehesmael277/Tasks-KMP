package com.sameh.taskskmp.utils

import app.cash.sqldelight.db.SqlDriver

expect class DatabaseDriverFactory {

    fun create(): SqlDriver
}