package br.com.joaorodrigues.repositories

import br.com.joaorodrigues.models.Task

class TasksRepository {

    val tasks get() = _tasks.toList()

    fun save (task: Task) {
        _tasks.add(task)
    }

    companion object {
        private val _tasks = mutableListOf<Task>()
    }

}