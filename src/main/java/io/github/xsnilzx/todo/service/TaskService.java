package io.github.xsnilzx.todo.service;
import java.time.LocalDate;
import java.util.List;
import io.github.xsnilzx.todo.model.Task;
import io.github.xsnilzx.todo.repository.TaskRepository;

public class TaskService {
    private final TaskRepository taskRepository;
    
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
    
    public void createTask(String title, String description, LocalDate dueDate) {
        Task newTask = new Task(title, description, dueDate);
        // Die save-Methode kümmert sich um das Hinzufügen zur Liste
        taskRepository.save(newTask);
    }
    
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }
    
    public void updateTask(Task task) {
        // Die save-Methode sollte auch Updates verarbeiten können
        taskRepository.save(task);
    }
    
    public Task getTaskById(Long id) {
        return taskRepository.findById(id);
    }
    
    public void deleteTask(Long id) {
        taskRepository.delete(id);
    }
    
    // Weitere Methoden zur Bearbeitung von Aufgaben können hier hinzugefügt werden
}