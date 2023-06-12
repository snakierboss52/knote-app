package com.jorge.controller;

import com.jorge.dtos.TaskDTO;
import com.jorge.entity.Task;
import com.jorge.mappers.ITaskMapper;
import com.jorge.service.TaskService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
@Slf4j
public class TaskController {

    private final TaskService taskService;

    private final ITaskMapper taskMapper;

    public TaskController(TaskService taskService, ITaskMapper taskMapper) {
        this.taskService = taskService;
        this.taskMapper = taskMapper;
    }

    @GetMapping("/task")
    public Optional<TaskDTO> getTaskById(
            @RequestParam Long id
    ){
        log.info("Going out to search task  from controller with identifier {}", id);
        return taskService.getTaskById(id);
    }

    @PostMapping ("/tasks")
    public TaskDTO createTask(
            @RequestBody TaskDTO taskDTO
    ){
        log.info("Getting body request to create task {}", taskDTO);

        final Task task = taskMapper.taskDTOToTaskEntity(taskDTO);

        return taskService.createTask(task);
    }

    @GetMapping("/tasks")
    public List<TaskDTO> getAllTasks(){

        log.info("Getting all tasks from controller request");

        return taskService.findAll();
    }

    /*
    @DeleteMapping("task/{id}")
    public ResponseEntity<TaskDTO> deleteTaskByTitle(
            @PathVariable Long id
    ){
        final Mono<Task> task = taskService.deleteTaskById(id);
        return task.map(TaskMapper::toTaskDTO);
    }

    @PutMapping("task/{id}")
    public ResponseEntity<TaskDTO> updateTaskByTitle(
            @PathVariable Long id,
            @RequestBody TaskDTO taskDTO
    ){
        final Mono<Task> task = taskService.updateTaskById(id, TaskMapper.toTaskEntity(taskDTO));
        return task.map(TaskMapper::toTaskDTO);
    }*/

}
