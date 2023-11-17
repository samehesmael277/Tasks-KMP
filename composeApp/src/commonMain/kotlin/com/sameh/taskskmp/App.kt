package com.sameh.taskskmp

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.sameh.taskskmp.data.model.Task
import com.sameh.taskskmp.ui.TaskState
import com.sameh.taskskmp.ui.TaskVM
import com.sameh.taskskmp.utils.AppModule
import dev.icerock.moko.mvvm.compose.getViewModel
import dev.icerock.moko.mvvm.compose.viewModelFactory

@Composable
internal fun App(appModule: AppModule) {
    val vm: TaskVM = getViewModel(
        "task_vm",
        factory = viewModelFactory {
            TaskVM(
                appModule.taskRepo
            )
        }
    )

    val state: TaskState by vm.state.collectAsState()

    TasksScreen(
        state.tasks,
        onAddTask = vm::addTask,
        onDeleteTask = vm::deleteTask
    )
}

@Composable
fun TasksScreen(
    tasks: List<Task>,
    onAddTask: (String) -> Unit,
    onDeleteTask: (Long) -> Unit
) {
    Scaffold {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            item {
                FieldView(onAddTask)
            }
            item {
                Text(
                    "My Tasks: ${tasks.size}",
                    fontWeight = FontWeight.Bold
                )
            }
            items(tasks) { task ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(task.title)
                    Icon(
                        Icons.Default.Delete, contentDescription = "Delete",
                        modifier = Modifier.clickable {
                            task.id?.let { id ->
                                onDeleteTask(id)
                            }
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun FieldView(
    onAddTask: (String) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        var title by remember {
            mutableStateOf("")
        }
        OutlinedTextField(
            value = title,
            onValueChange = {
                title = it
            },
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier.weight(1f),
            placeholder = {
                Text("Write your task")
            }
        )
        Button(
            onClick = {
                if (title.isNotEmpty())
                    onAddTask(title)
                title = ""
            }
        ) {
            Text("Add")
        }
    }
}

internal expect fun openUrl(url: String?)