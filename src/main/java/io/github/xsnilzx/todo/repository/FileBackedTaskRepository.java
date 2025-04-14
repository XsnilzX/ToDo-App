package io.github.xsnilzx.todo.repository;

import io.github.xsnilzx.todo.model.Task;
import io.github.xsnilzx.todo.model.TaskStorage;
import java.util.List;

public class FileBackedTaskRepository implements TaskRepository {
    private final TaskStorage taskStorage;
    
    public FileBackedTaskRepository(TaskStorage taskStorage) {
        this.taskStorage = taskStorage;
    }
    
    @Override
    public List<Task> findAll() {
        return taskStorage.loadTasksFromFile();
    }
    
    @Override
    public Task findById(Long id) {
        return taskStorage.loadTasksFromFile().stream()
                .filter(task -> id.equals(task.getId()))
                .findFirst()
                .orElse(null);
    }
    
    @Override
    public Task save(Task task) {
        List<Task> tasks = taskStorage.loadTasksFromFile();
        
        // If task has an ID, it's an update
        if (task.getId() != null) {
            tasks.removeIf(t -> t.getId().equals(task.getId()));
        } else {
            // Generate a new ID (simple approach)
            Long newId = tasks.stream()
                    .mapToLong(Task::getId)
                    .max()
                    .orElse(0) + 1;
            task.setId(newId);
        }
        
        tasks.add(task);
        taskStorage.saveTasksToFile(tasks);
        return task;
    }
    
    @Override
    public void delete(Long id) {
        List<Task> tasks = taskStorage.loadTasksFromFile();
        tasks.removeIf(task -> id.equals(task.getId()));
        taskStorage.saveTasksToFile(tasks);
    }
}