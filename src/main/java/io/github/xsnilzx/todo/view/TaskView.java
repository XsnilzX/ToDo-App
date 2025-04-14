package io.github.xsnilzx.todo.view;

import io.github.xsnilzx.todo.controller.TaskController;
import io.github.xsnilzx.todo.model.Task;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class TaskView extends BorderPane {
    private final TaskController controller;
    private ListView<Task> taskListView;
    private TextField titleField;
    private TextField descriptionField;
    
    public TaskView(TaskController controller) {
        this.controller = controller;
        setupUI();
    }
    
    private void setupUI() {
        setPadding(new Insets(20));
        
        // Header
        Label headerLabel = new Label("ToDo-App");
        headerLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");
        setTop(headerLabel);
        BorderPane.setAlignment(headerLabel, Pos.CENTER);
        BorderPane.setMargin(headerLabel, new Insets(0, 0, 20, 0));
        
        // Center - Task List
        taskListView = new ListView<>();
        taskListView.setCellFactory(param -> new TaskCell(controller));
        
        // Refresh list initially
        refreshTaskList();
        
        setCenter(taskListView);
        
        // Bottom - Input Form
        VBox inputForm = new VBox(10);
        inputForm.setPadding(new Insets(20, 0, 0, 0));
        
        Label newTaskLabel = new Label("Neue Aufgabe");
        newTaskLabel.setStyle("-fx-font-weight: bold;");
        
        titleField = new TextField();
        titleField.setPromptText("Titel");
        
        descriptionField = new TextField();
        descriptionField.setPromptText("Beschreibung (optional)");
        
        HBox buttonBar = new HBox(10);
        Button addButton = new Button("Hinzufügen");
        Button clearButton = new Button("Zurücksetzen");
        
        // Make Add button wider
        addButton.setPrefWidth(150);
        
        buttonBar.getChildren().addAll(addButton, clearButton);
        buttonBar.setAlignment(Pos.CENTER_RIGHT);
        
        inputForm.getChildren().addAll(newTaskLabel, titleField, descriptionField, buttonBar);
        setBottom(inputForm);
        
        // Event handlers
        addButton.setOnAction(e -> {
            if (!titleField.getText().trim().isEmpty()) {
                controller.addTask(titleField.getText().trim(), descriptionField.getText().trim());
                clearFields();
                refreshTaskList();
            }
        });
        
        clearButton.setOnAction(e -> clearFields());
    }
    
    private void clearFields() {
        titleField.clear();
        descriptionField.clear();
        titleField.requestFocus();
    }
    
    private void refreshTaskList() {
        taskListView.getItems().setAll(controller.getTaskList());
    }
}