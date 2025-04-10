package io.github.xsnilzx.todo;

import io.github.xsnilzx.todo.controller.TaskController;
import io.github.xsnilzx.todo.repository.InMemoryTaskRepository;
import io.github.xsnilzx.todo.repository.TaskRepository;
import io.github.xsnilzx.todo.service.TaskService;
import io.github.xsnilzx.todo.view.TaskView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        // Anwendungskomponenten initialisieren
        TaskRepository repository = new InMemoryTaskRepository();
        TaskService service = new TaskService(repository);
        TaskController controller = new TaskController(service);
        
        // UI erstellen
        TaskView view = new TaskView(controller);
        Scene scene = new Scene(view, 600, 400);
        
        primaryStage.setTitle("ToDo App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}