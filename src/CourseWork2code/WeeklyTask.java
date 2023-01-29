package CourseWork2code;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class WeeklyTask extends Task {
    //        implements Comparable
    private final LocalDateTime dateTime;
    private final LocalDate taskDate;
    private final Integer id;

    public WeeklyTask(String title, Type type, String description) {
        super(title, type, description);
        this.id = idGenerator;
        this.dateTime = LocalDateTime.now();
        this.taskDate = LocalDate.now();
    }

    @Override
    public boolean appearsIn(LocalDate d) {
        if (d.getDayOfWeek() == getTaskDate().getDayOfWeek())
        return true;
        else return false;
    }

    @Override
    public String toString() {
        return "Еженедельная задача № " + id +
                " : " + getTitle() + " (" + getType() + "), время создания = " + dateTime +
                "\n краткое описание: " + getDescription();
    }

    @Override
    public LocalDate getTaskDate() {
        return taskDate;
    }
}

