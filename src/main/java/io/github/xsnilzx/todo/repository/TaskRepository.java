package io.github.xsnilzx.todo.repository;

import io.github.xsnilzx.todo.model.Task;
import java.util.List;

public interface TaskRepository {
    List<Task> findAll();
    Task findById(Long id);
    Task save(Task task);
    void delete(Long id);
    // Weitere Methoden
}