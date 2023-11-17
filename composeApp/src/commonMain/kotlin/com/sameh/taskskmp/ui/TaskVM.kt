package com.sameh.taskskmp.ui

import com.sameh.taskskmp.data.repo.TaskRepo
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class TaskVM(
    private val taskRepo: TaskRepo
) : ViewModel() {

    private val _state = MutableStateFlow(TaskState())

    val state = combine(
        _state,
        taskRepo.getTasks()
    ) { state, task ->
        state.copy(tasks = task)
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000L), TaskState())

    fun addTask(title: String) {
        viewModelScope.launch {
            taskRepo.addTask(title)
        }
    }

    fun deleteTask(id: Long) {
        viewModelScope.launch {
            taskRepo.deleteTask(id)
        }
    }
}