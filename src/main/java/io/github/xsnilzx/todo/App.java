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
    private static TaskStorage taskStorage;
    private static TaskRepository taskRepository;
    private static TaskService taskService;
    private static TaskController taskController;
    
    @Override
    public void start(Stage primaryStage) {
        // Verwende die in main() erstellten Instanzen
        // View mit dem Controller erstellen
        TaskView view = new TaskView(taskController);
        
        Scene scene = new Scene(view, 600, 400);
        primaryStage.setTitle("ToDo App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        // Initialisiere alle Objekte vor dem Start der Anwendung
        taskStorage = new TaskStorage();
        taskRepository = new FileBackedTaskRepository(taskStorage);
        taskService = new TaskService(taskRepository);  // Übergebe repository, nicht storage
        taskController = new TaskController(taskService);
        
        // Start GUI
        launch(args);
    }
}