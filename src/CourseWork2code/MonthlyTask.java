package CourseWork2code;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class MonthlyTask extends Task {
    //        implements Comparable
    private final LocalDateTime dateTime;
    private final int id;

    public MonthlyTask(String title, Type type, String description) {
        super(title, type, description);
        this.id = idGenerator;
        this.dateTime = LocalDateTime.now();
    }

    @Override
    public boolean appearsIn(LocalDate d) {
        return true;
    }

    @Override
    public String toString() {
        return "Ежемесячная задача № " + id +
                " : " + getTitle() + " (" + getType() + "), время создания = " + dateTime +
                "\n краткое описание: " + getDescription();
    }
}

