// src/main/java/io/github/xsnilzx/todo/repository/InMemoryTaskRepository.java
package io.github.xsnilzx.todo.repository;

import io.github.xsnilzx.todo.model.Task;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class InMemoryTaskRepository implements TaskRepository {
    private final Map<Long, Task> tasks = new HashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);
    
    @Override
    public List<Task> findAll() {
        return new ArrayList<>(tasks.values());
    }
    
    @Override
    public Task findById(Long id) {
        return tasks.get(id);
    }
    
    @Override
    public Task save(Task task) {
        if (task.getId() == null) {
            task.setId(idGenerator.getAndIncrement());
        }
        tasks.put(task.getId(), task);
        return task;
    }
    
    @Override
    public void delete(Long id) {
        tasks.remove(id);
    }
}