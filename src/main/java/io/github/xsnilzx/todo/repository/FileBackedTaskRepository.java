package io.github.xsnilzx.todo.repository;

import io.github.xsnilzx.todo.model.Task;
import io.github.xsnilzx.todo.model.TaskStorage;
import java.util.List;

public class FileBackedTaskRepository implements TaskRepository {

    private final InMemoryTaskRepository inMemoryRepo;
    private final TaskStorage taskStorage;

    public FileBackedTaskRepository(TaskStorage taskStorage) {
        this.inMemoryRepo = new InMemoryTaskRepository();
        this.taskStorage = taskStorage;
        
        // Lade bestehende Aufgaben beim Start
        List<Task> tasks = taskStorage.loadTasksFromFile();
        tasks.forEach(inMemoryRepo::save);
    }

    @Override
    public List<Task> findAll() {
        return inMemoryRepo.findAll();
    }

    @Override
    public Task findById(Long id) {
        return inMemoryRepo.findById(id);
    }
    
    @Override
    public Task save(Task task) {
        Task savedTask = inMemoryRepo.save(task);
        persistTasks();
        return savedTask;
    }
    
    @Override
    public void delete(Long id) {
        inMemoryRepo.delete(id);
        persistTasks();
    }

    private void persistTasks() {
        List<Task> tasks = inMemoryRepo.findAll();
        taskStorage.saveTasksToFile(tasks);
    }
}