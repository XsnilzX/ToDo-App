package io.github.xsnilzx.todo.service;

import io.github.xsnilzx.todo.model.Task;
import io.github.xsnilzx.todo.model.TaskStorage;
import java.util.List;

public class TaskService {

    private final TaskStorage taskStorage;

    public TaskService(TaskStorage taskStorage) {
        this.taskStorage = taskStorage;
    }

    public void createTask(String title, String description) {
        Task newTask = new Task(title, description);
        List<Task> tasks = taskStorage.loadTasksFromFile();
        tasks.add(newTask);
        taskStorage.saveTasksToFile(tasks);
    }

    public List<Task> getAllTasks() {
        return taskStorage.loadTasksFromFile();
    }

    // Weitere Methoden zur Bearbeitung von Aufgaben (z.B. als erledigt markieren, löschen, etc.)
}