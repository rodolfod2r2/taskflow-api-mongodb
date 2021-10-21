package org.framework.rodolfo.freire.git.taskflow.service;


import org.framework.rodolfo.freire.git.taskflow.document.Task;
import org.framework.rodolfo.freire.git.taskflow.repository.TaskRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService implements GenericsInterfaceService<Task> {

    final
    TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Page<Task> findAllPage(Pageable pageable) {
        return taskRepository.findAll(pageable);
    }

    @Override
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public Optional<Task> findById(String id) {
        return taskRepository.findById(id);
    }

    @Override
    public Task save(Task task) {
        return taskRepository.save(task);
    }
}
