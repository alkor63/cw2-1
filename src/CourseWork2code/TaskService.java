package CourseWork2code;

import java.time.LocalDate;
import java.util.*;

public class TaskService {
    private Map<Integer, Task> taskMap(Integer id){
        return taskMap(id);
    }
    private Set<Task> removedTasks(){
        return null;
    }

    public static void inputTask(Scanner scanner, List<Task> tasks) {
        Scanner scanner1 = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);

        System.out.print("Введите название задачи: ");
        String taskName = scanner.next();
        System.out.print("Введите краткое описание задачи: ");
        String taskDescription = scanner1.next();
        System.out.print("\n *** Выберите тип задачи:\n 1 - рабочая (Work)\n 2 - личная (Personal)\n ваш выбор? :");
        Type taskTyp = Type.PERSONAL;

        int menu2 = scanner2.nextInt();

        switch (menu2) {
            case 1:
                taskTyp = Type.WORK;
                break;
            case 2:
                taskTyp = Type.PERSONAL;
                break;
            default: {
                System.out.println("ТИП задачи указан невнрно, ты всё сломал !");
                taskTyp = Type.valueOf("ЛИЧНАЯ");
            }
        }

        System.out.print("\n *** Выберите повторяемость задачи:\n 1 - однократная\n" +
                " 2 - ежедневная\n 3 - еженедельная\n" +
                " 4 - ежемесячная\n 5 - ежегодная\n" +
                "ваш выбор? :");
        Task task9;
        int menu = scanner2.nextInt();
        switch (menu) {
            case 1:
                task9 = new OneTimeTask(taskName, taskTyp, taskDescription);
                break;
            case 2:
                task9 = new DailyTask(taskName, taskTyp, taskDescription);
                break;
            case 3:
                task9 = new WeeklyTask(taskName, taskTyp, taskDescription);
                break;
            case 4:
                task9 = new MonthlyTask(taskName, taskTyp, taskDescription);
                break;
            case 5:
                task9 = new YearlyTask(taskName, taskTyp, taskDescription);
                break;
            default: {
                System.out.println("ПОВТОРЯЕМОСТЬ задачи указана невнрно, ты всё сломал !");
                task9 = new OneTimeTask(taskName, taskTyp, taskDescription);
            }
        }

        if (!tasks.contains(task9)) tasks.add(task9);
        System.out.println("Вот что вы навводили:\n" + task9);
    }
public static Task updateDescription(int id, Task task){
    Scanner scanner = new Scanner(System.in);
    System.out.print("Введите краткое описание задачи: ");
    String taskDescription = scanner.next();
    task.setDescription(taskDescription);
    return task;
}

public static Set<Task> getRemovedTasks(){
        return getRemovedTasks();
}

public static Task remove(int id, Task task){
        if(task.getId() == id) {}
    return task;
}

public static Map<LocalDate, Set<Task>> getAllGroupByDate(LocalDate date, Task task){
    System.out.println(task.getDateTime());
    return getAllGroupByDate(date,task);
}

public static Task updateTitle(int id, String title) {
        return updateTitle(id, title);
}

public static Set<Task> getAllByDate(LocalDate date) {
        return getAllByDate(date);
}

}
