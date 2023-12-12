package br.com.joaorodrigues.dto

import br.com.joaorodrigues.models.Task
import kotlinx.serialization.Serializable

@Serializable
class TaskRequest (
    val title: String,
    val description: String
){

    fun toTask() = Task(
        title = title,
        description = description

    )

}