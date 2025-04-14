package io.github.xsnilzx.todo.view;

import io.github.xsnilzx.todo.controller.TaskController;
import io.github.xsnilzx.todo.model.Task;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

public class TaskCell extends ListCell<Task> {
    private HBox content;
    private CheckBox checkBox;
    private Label titleLabel;
    private final TaskController controller;

    public TaskCell(TaskController controller) {
        super();
        this.controller = controller;
        
        checkBox = new CheckBox();
        titleLabel = new Label();
        
        content = new HBox(10);
        content.getChildren().addAll(checkBox, titleLabel);
        HBox.setHgrow(titleLabel, Priority.ALWAYS);
    }

    @Override
    protected void updateItem(Task task, boolean empty) {
        super.updateItem(task, empty);
        
        if (empty || task == null) {
            setText(null);
            setGraphic(null);
        } else {
            titleLabel.setText(task.getTitle());
            checkBox.setSelected(task.isCompleted());
            
            // Checkbox-Event-Handler
            checkBox.setOnAction(event -> {
                task.setCompleted(checkBox.isSelected());
                controller.updateTask(task);
            });
            
            setGraphic(content);
        }
    }
}