package io.github.xsnilzx.todo;

import io.github.xsnilzx.todo.model.TaskStorage;
import io.github.xsnilzx.todo.repository.FileBackedTaskRepository;
import io.github.xsnilzx.todo.repository.InMemoryTaskRepository;
import io.github.xsnilzx.todo.repository.TaskRepository;
import io.github.xsnilzx.todo.service.TaskService;
import io.github.xsnilzx.todo.view.TaskView;
import io.github.xsnilzx.todo.controller.TaskController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    private TaskStorage taskStorage;
    private FileBackedTaskRepository taskRepository;
    private TaskService taskService;
    private TaskController taskController;

    @Override
    public void start(Stage primaryStage) {
        // UI erstellen
        TaskView view = new TaskView(taskController);
        Scene scene = new Scene(view, 600, 400);
        
        primaryStage.setTitle("ToDo App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        TaskStorage taskStorage = new TaskStorage();
        FileBackedTaskRepository taskRepository = new FileBackedTaskRepository(taskStorage);
        TaskService taskService = new TaskService(taskStorage);
        TaskController taskController = new TaskController(taskService);

        // Start GUI
        launch(args);
    }
}