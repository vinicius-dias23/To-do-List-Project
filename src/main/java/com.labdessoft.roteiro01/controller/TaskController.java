package com.labdessoft.roteiro01.controller; 
 
import com.labdessoft.roteiro01.repository.TaskRepository; 
import com.labdessoft.roteiro01.service.ServiceTask; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.RestController; 
import io.swagger.v3.oas.annotations.Operation; 

@RestController 
public class TaskController { 
    @Autowired 
    TaskRepository taskRepository; 

    @Autowired 
    ServiceTask service; 

    @GetMapping("/task") 
    @Operation(summary = "Lista todas as tarefas da lista") 
    public String listAll() { 
        return service.ServiceListTask(); 
    } 

    @GetMapping("/include-task") 
    @Operation(summary = "Inclui nova tarefa na lista de tarefas") 
    public String include() { 
        return service.ServiceIncludeTask("Nova Tarefa!", false); 
    } 

    @GetMapping("/delete-task") 
    @Operation(summary = "Deleta uma tarefa da lista de tarefas") 
    public String delete() { 
        return service.ServiceDeleteTask(1L); 
    } 
}