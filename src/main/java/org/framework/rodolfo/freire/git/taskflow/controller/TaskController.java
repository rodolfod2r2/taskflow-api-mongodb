package org.framework.rodolfo.freire.git.taskflow.controller;


import org.framework.rodolfo.freire.git.taskflow.document.Task;
import org.framework.rodolfo.freire.git.taskflow.service.TaskService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
public class TaskController {

    final
    TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping(value = "/task")
    public ResponseEntity<List<Task>> getAllTask() {
        List<Task> listTask = taskService.findAll();
        return new ResponseEntity<>(listTask, HttpStatus.ACCEPTED);
    }

    @GetMapping(value = "/task/pages", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> getAllTaskPages(
            @RequestParam(defaultValue = "0") int numberPage,
            @RequestParam(defaultValue = "3") int intervalPage
    ) {
        try {
            List<Task> elements;
            Pageable paging = PageRequest.of(numberPage, intervalPage);
            Page<Task> pages = taskService.findAllPage(paging);
            elements = pages.getContent();
            if (elements.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            Map<String, Object> response = new HashMap<>();
            response.put("task", elements);
            response.put("currentPage", pages.getNumber());
            response.put("totalItems", pages.getTotalElements());
            response.put("totalPages", pages.getTotalPages());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/task/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable String id) {
        Optional<Task> task = taskService.findById(id);
        return task.map(task1 -> new ResponseEntity<>(task1, HttpStatus.ACCEPTED)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(value = "/task")
    public ResponseEntity<Task> save(@RequestBody Task user) {
        return new ResponseEntity<>(taskService.save(user), HttpStatus.CREATED);
    }
}
