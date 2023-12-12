package br.com.joaorodrigues.plugins

import br.com.joaorodrigues.dto.TaskRequest
import br.com.joaorodrigues.dto.toTaskResponse
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
            val response = repository.tasks().map {
                it.toTaskResponse()
            }
            call.respond(response)
        }

        post("/tasks") {
            val request = call.receive<TaskRequest>()
            repository.save(request.toTask())?.let {
                call.respondText (
                    "Task created successfully",
                    status = HttpStatusCode.Created)
            }?:
            call.respondText (
                "Task not created",
                status = HttpStatusCode.BadRequest)
        }
    }

}
