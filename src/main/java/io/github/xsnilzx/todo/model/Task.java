package io.github.xsnilzx.todo.model;

import java.time.LocalDate;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;

public class Task {

    private static final AtomicLong ID_GENERATOR = new AtomicLong(1);
    private Long id;
    private String title;
    private String description;
    private boolean completed;
    private LocalDate date;
    private LocalDate dueDate;

    public Task(String title, String description, LocalDate dueDate) {
        this.id = ID_GENERATOR.getAndIncrement();
        this.title = title;
        this.description = description;
        this.completed = false;
        this.date = LocalDate.now().plusDays(7);
        this.dueDate = dueDate;
    }

    // Konstruktor für das Laden aus JSON
    public Task() {
        // Leerer Konstruktor für JSON-Deserialisierung
    }

    // Methode zur Initialisierung des ID-Generators nach dem Laden
    public static void updateIdGenerator(long maxId) {
        ID_GENERATOR.set(Math.max(ID_GENERATOR.get(), maxId + 1));
    }

    // Getter und Setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return (
            completed == task.completed &&
            Objects.equals(id, task.id) &&
            Objects.equals(title, task.title) &&
            Objects.equals(description, task.description) &&
            Objects.equals(dueDate, task.dueDate)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, completed, dueDate);
    }
}
