package com.labdessoft.roteiro01.controller;
import com.labdessoft.roteiro01.entity.Task;
import com.labdessoft.roteiro01.repository.TaskRepository;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class TaskController {
    @Autowired
    TaskRepository taskRepository;
    @GetMapping("/tarefa")
    @Operation(summary = "Lista todas as tarefas da lista")
    public ResponseEntity<List<Task>> listAll() {
        try{
            List<Task> taskList = new ArrayList<Task>();
            taskRepository.findAll().forEach(taskList::add);
            if(taskList.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(taskList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/tarefa/{id}")
    @Operation(summary = "Recupera uma tarefa pelo ID")
    public ResponseEntity<Task> listOne(@PathVariable("id") Long id) {
        try {
            Optional<Task> taskData = taskRepository.findById(id);
            if (taskData.isPresent()) {
                return new ResponseEntity<>(taskData.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/tarefa")
    @Operation(summary = "Salva uma nova tarefa")
    public ResponseEntity<Task> addTask(@RequestBody Task task) {
        try {
            Task newTask = taskRepository.save(task);
            return new ResponseEntity<>(newTask, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/tarefa/{id}")
    @Operation(summary = "Edita uma tarefa")
    public ResponseEntity<Task> editTask(@PathVariable("id") Long id, @RequestBody Task task) {
        try {
            Task tarefaEditada = taskRepository.findById(id).get();
            task.setId(tarefaEditada.getId());
            Task newTask = taskRepository.save(task);
            return new ResponseEntity<>(newTask, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/tarefa/{id}")
    @Operation(summary = "Exclui uma tarefa")
    public ResponseEntity<Task> removeTask(@PathVariable("id") Long id) {
        try {
            Task taskDeletada = taskRepository.findById(id).get();
            taskRepository.delete(taskDeletada);
            return new ResponseEntity<>(taskDeletada, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}