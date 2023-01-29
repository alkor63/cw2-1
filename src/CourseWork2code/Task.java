package CourseWork2code;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public abstract class Task {
    static int idGenerator = 0;
    private String title;
    private final Type type;
    private final LocalDateTime dateTime;
    private final LocalDate taskDate;
    private String description;
    private final int id;

    public Task(String title, Type type, String description) {
        idGenerator++;
        this.id = idGenerator;
        this.dateTime = LocalDateTime.now();
        this.type = type;
        if (nullString(title)) title = "БЕЗЫМЯННАЯ задача";
        this.title = title;
        if (nullString(description)) description = "описание отсутствует (:";
        this.description = description;
        this.taskDate = LocalDate.now();
    }

    public LocalDate getTaskDate() {         return taskDate;    }

    public abstract boolean appearsIn(LocalDate d);

    public Type getType() {
        return type;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public Integer getId() {
        return id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id && Objects.equals(title, task.title) && type == task.type && Objects.equals(dateTime, task.dateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, type, dateTime, id);
    }

    @Override
    public String toString() {
        return "Задача № " + id +
                " : " + title + " (" + type + "), время создания = " + dateTime +
                "\n краткое описание: " + description;
    }

    public static boolean nullString(String s) {
        return (s == null || s.isEmpty() || s.isBlank());
    }
}

