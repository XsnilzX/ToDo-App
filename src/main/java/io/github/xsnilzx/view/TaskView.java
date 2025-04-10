package io.github.xsnilzx.todo.view;

import io.github.xsnilzx.todo.controller.TaskController;
import io.github.xsnilzx.todo.model.Task;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class TaskView extends BorderPane {
    private final TaskController controller;
    private TextField titleField;
    private ListView<Task> taskListView;
    
    public TaskView(TaskController controller) {
        this.controller = controller;
        initializeUI();
    }
    
    private void initializeUI() {
        // Oberer Bereich (Eingabefelder)
        titleField = new TextField();
        Button addButton = new Button("Hinzufügen");
        addButton.setOnAction(e -> addTask());
        
        HBox inputBox = new HBox(5, new Label("Titel:"), titleField, addButton);
        setTop(inputBox);
        
        // Mittlerer Bereich (Liste der Aufgaben)
        taskListView = new ListView<>();
        taskListView.setItems(controller.getTaskList());
        setCenter(taskListView);
        
        // Rendering der Listeneinträge anpassen
        taskListView.setCellFactory(param -> new ListCell<>() {
            @Override
            protected void updateItem(Task task, boolean empty) {
                super.updateItem(task, empty);
                if (empty || task == null) {
                    setText(null);
                } else {
                    setText(task.getTitle() + (task.isCompleted() ? " ✓" : ""));
                }
            }
        });
    }
    
    private void addTask() {
        String title = titleField.getText().trim();
        if (!title.isEmpty()) {
            controller.addTask(title, "");
            titleField.clear();
        }
    }
}