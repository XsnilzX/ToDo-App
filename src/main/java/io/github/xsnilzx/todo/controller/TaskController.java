package io.github.xsnilzx.todo.controller;

import io.github.xsnilzx.todo.model.Task;
import io.github.xsnilzx.todo.service.TaskService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class TaskController {
    private final TaskService service;
    private final ObservableList<Task> taskList = FXCollections.observableArrayList();
    
    public TaskController(TaskService service) {
        this.service = service;
        refreshTasks();
    }
    
    public void addTask(String title, String description) {
        service.createTask(title, description);
        refreshTasks();
    }
    
    public void completeTask(Long id) {
        // Logik zum Abhaken einer Aufgabe
        refreshTasks();
    }
    
    private void refreshTasks() {
        taskList.setAll(service.getAllTasks());
    }
    
    public ObservableList<Task> getTaskList() {
        return taskList;
    }
}