package io.github.xsnilzx.todo.model;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class TaskStorage {
    private static final String FILE_PATH = "tasks.json";
    private final Gson gson;
    
    public TaskStorage() {
        // Erstelle einen benutzerdefinierten TypeAdapter für LocalDate
        gson = new GsonBuilder()
            .setPrettyPrinting()
            .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
            .create();
    }
    
    public void saveTasksToFile(List<Task> tasks) {
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            gson.toJson(tasks, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public List<Task> loadTasksFromFile() {
        File file = new File(FILE_PATH);
        
        // Überprüfe, ob die Datei existiert
        if (!file.exists()) {
            try {
                // Erstelle die Datei und speichere eine leere Liste
                file.createNewFile();
                saveTasksToFile(new ArrayList<>());
            } catch (IOException e) {
                e.printStackTrace();
                return new ArrayList<>();
            }
        }
        
        // Lade Daten aus der existierenden Datei
        try (FileReader reader = new FileReader(file)) {
            Type taskListType = new TypeToken<List<Task>>() {}.getType();
            List<Task> tasks = gson.fromJson(reader, taskListType);
            // Null-Check für den Fall, dass die Datei leer ist
            return tasks != null ? tasks : new ArrayList<>();
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
    
    // Adapter für LocalDate
    private static class LocalDateAdapter implements JsonSerializer<LocalDate>, JsonDeserializer<LocalDate> {
        private final DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
        
        @Override
        public JsonElement serialize(LocalDate date, Type typeOfSrc, JsonSerializationContext context) {
            return new JsonPrimitive(formatter.format(date));
        }
        
        @Override
        public LocalDate deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) 
                throws JsonParseException {
            return LocalDate.parse(json.getAsString(), formatter);
        }
    }
}