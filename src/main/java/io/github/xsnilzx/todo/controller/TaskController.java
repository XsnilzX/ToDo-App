package io.github.xsnilzx.todo.controller;

import java.time.LocalDate;

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
    
    public void addTask(String title, String description, LocalDate dueDate) {
        service.createTask(title, description, dueDate);
        refreshTasks();
    }
    
    public void updateTask(Task task) {
        service.updateTask(task);
    }
    
    private void refreshTasks() {
        taskList.setAll(service.getAllTasks());
    }
    
    public ObservableList<Task> getTaskList() {
        return taskList;
    }
}