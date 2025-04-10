package io.github.xsnilzx.todo.service;

import io.github.xsnilzx.todo.model.Task;
import io.github.xsnilzx.todo.repository.TaskRepository;
import java.util.List;

public class TaskService {
    private final TaskRepository repository;
    
    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }
    
    public List<Task> getAllTasks() {
        return repository.findAll();
    }
    
    public Task createTask(String title, String description) {
        Task task = new Task();
        task.setTitle(title);
        task.setDescription(description);
        task.setCompleted(false);
        
        return repository.save(task);
    }
    
    // Weitere Geschäftslogik
}