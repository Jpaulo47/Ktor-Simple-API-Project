package br.com.joaorodrigues.plugins

import br.com.joaorodrigues.models.Task
import br.com.joaorodrigues.repositories.TasksRepository
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    val repository = TasksRepository()
    routing {
        get("/tasks") {
            call.respond(repository.tasks)
        }

        post("/tasks") {
            val task = call.receive<Task>()
            repository.save(task)
            call.respondText ( "Task created successfully",
                status = HttpStatusCode.Created)
        }
    }

}
