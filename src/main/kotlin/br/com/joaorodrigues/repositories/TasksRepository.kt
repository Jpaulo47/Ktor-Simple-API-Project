package br.com.joaorodrigues.repositories

import br.com.joaorodrigues.database.dao.TaskDao
import br.com.joaorodrigues.models.Task

class TasksRepository (
    private val dao : TaskDao = TaskDao()
){

    suspend fun tasks() = dao.findAll()

    suspend fun save (task: Task) = dao.save(task)

}