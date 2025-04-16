package io.github.xsnilzx.todo;

import io.github.xsnilzx.todo.controller.TaskController;
import io.github.xsnilzx.todo.model.TaskStorage;
import io.github.xsnilzx.todo.repository.FileBackedTaskRepository;
import io.github.xsnilzx.todo.repository.TaskRepository;
import io.github.xsnilzx.todo.service.TaskService;
import io.github.xsnilzx.todo.view.TaskView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class App extends Application {

    // Statische Felder für den Zugriff aus start()
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
        primaryStage.setResizable(true);
        setAppIcon(primaryStage);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void setAppIcon(Stage stage) {
        Image icon = new Image(
            getClass().getResourceAsStream("/icons/Icon.png")
        );
        stage.getIcons().clear();
        stage.getIcons().add(icon);
    }

    public static void main(String[] args) {
        // Initialisiere alle Objekte vor dem Start der Anwendung
        taskStorage = new TaskStorage();
        taskRepository = new FileBackedTaskRepository(taskStorage);
        taskService = new TaskService(taskRepository);
        taskController = new TaskController(taskService);

        // Start GUI
        launch(args);
    }
}
