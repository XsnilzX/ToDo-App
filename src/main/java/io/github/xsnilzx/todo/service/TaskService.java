package io.github.xsnilzx.todo.service;

import io.github.xsnilzx.todo.model.Task;
import io.github.xsnilzx.todo.repository.TaskRepository;
import java.util.List;

public class TaskService {
    private final TaskRepository taskRepository;
    
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
    
    public void createTask(String title, String description) {
        Task newTask = new Task(title, description);
        taskRepository.save(newTask);
    }
    
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }
    
    // Weitere Methoden...
}