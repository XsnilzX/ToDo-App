# Java ToDo App

Eine einfache und effiziente ToDo-Anwendung, entwickelt in Java mit Maven als Build-System.

## Übersicht

Diese ToDo-Anwendung ermöglicht das Erstellen, Verwalten und Organisieren von Aufgaben. Sie bietet eine benutzerfreundliche Oberfläche und grundlegende Funktionen zur Aufgabenverwaltung.

## Funktionen

- Aufgaben erstellen, bearbeiten und löschen
- Aufgaben als erledigt markieren
- Aufgaben nach Priorität sortieren
- Fälligkeitsdaten für Aufgaben festlegen
- Aufgaben in Kategorien organisieren
- Suchfunktion für Aufgaben
- Datenpersistenz (lokale Speicherung)

## Technologie-Stack

- Java 21
- Maven (Build-System)
- JavaFX (für die Benutzeroberfläche)
- JUnit 5 (für Tests)
- H2 Database (für die lokale Datenspeicherung)

## Voraussetzungen

- Java Development Kit (JDK) 17 oder höher
- Maven 3.6.0 oder höher
- Git (optional, für das Klonen des Repositories)

## Installation

1. Klone das Repository oder lade den Quellcode herunter:
   ```
   git clone https://github.com/XsnilzX/ToDo-App.git
   ```

2. Navigiere zum Projektverzeichnis:
   ```
   cd ToDo-App
   ```

3. Kompiliere und baue die Anwendung mit Maven:
   ```
   work in progress
   ```

4. Starte die Anwendung:
   ```
   work in progress
   ```

## Maven-Konfiguration

Das Projekt verwendet Maven als Build-System. Die Konfiguration ist in der `pom.xml`-Datei definiert. Die wichtigsten Abhängigkeiten sind:

- JavaFX für die GUI
- H2 Database für die Datenspeicherung
- JUnit 5 für Tests

Um zusätzliche Abhängigkeiten hinzuzufügen, bearbeite einfach die `pom.xml`-Datei.

## Projektstruktur

```
Todo-App/
├── LICENSE
├── pom.xml
├── README.md
└── src
    └── main
        ├── java
        │   └── io
        │       └── github
        │           └── xsnilzx
        │               └── todo
        │                   ├── App.java
        │                   ├── controller
        │                   │   └── TaskController.java
        │                   ├── model
        │                   │   ├── Task.java
        │                   │   └── TaskStorage.java
        │                   ├── repository
        │                   │   ├── FileBackedTaskRepository.java
        │                   │   ├── InMemoryTaskRepository.java
        │                   │   └── TaskRepository.java
        │                   ├── service
        │                   │   └── TaskService.java
        │                   └── view
        │                       ├── TaskCell.java
        │                       └── TaskView.java
        └── resources
            └── icons
                └── Icon.png
```

## Verwendung

Nach dem Start der Anwendung kannst du:

1. Neue Aufgaben mit dem "+" Button hinzufügen
2. Aufgaben bearbeiten, indem du auf sie doppelklickst
3. Aufgaben als erledigt markieren, indem du die Checkbox anklickst
4. Kategorien für Aufgaben über das Dropdown-Menü auswählen
5. Aufgaben nach verschiedenen Kriterien sortieren
6. Aufgaben über die Suchleiste finden

## Entwicklung

Um an diesem Projekt mitzuarbeiten:

1. Forke das Repository
2. Erstelle einen Feature-Branch:
   ```
   git checkout -b feature/neue-funktion
   ```
3. Committe deine Änderungen:
   ```
   git commit -m 'Neue Funktion hinzugefügt'
   ```
4. Pushe zu deinem Branch:
   ```
   git push origin feature/neue-funktion
   ```
5. Erstelle einen Pull Request

## Tests ausführen

```
mvn test
```

## Build für Produktion

```
mvn clean package -P production
```

Dies erstellt eine ausführbare JAR-Datei im `target`-Verzeichnis.

## Lizenz

[MIT](https://choosealicense.com/licenses/mit/)

## Kontakt

Richard Taesler - [richard.hans.taesler@stud.uni-hannover.de](mailto:richard.hans.taesler@stud.uni-hannover.de)

Projekt-Link: [https://github.com/yourusername/java-todo-app](https://github.com/XsnilzX/ToDo-App.git)