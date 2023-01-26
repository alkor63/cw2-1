import CourseWork2code.*;

import javax.sound.sampled.AudioFileFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        LocalDate inputDate = LocalDate.of(2022, 11, 10);
        System.out.println("Input дата : " + inputDate);
        System.out.println("Текущая дата : " + LocalDate.now());
//        System.out.println("Текущая дата : "+LocalDateTime.now());

        OneTimeTask task1 = new OneTimeTask("Task #1 oneTime", Type.WORK, null);
        OneTimeTask task2 = new OneTimeTask("Task #2 oneTime", Type.PERSONAL, "Barbershop");
        OneTimeTask task3 = new OneTimeTask("Task #3 oneTime", Type.WORK, " ");
        DailyTask task4 = new DailyTask("Task #4 dayly", Type.WORK, "Проверить почту");
        DailyTask task5 = new DailyTask("Task #5 dayly", Type.PERSONAL, "почистить зубы");
        WeeklyTask task6 = new WeeklyTask("Task #6 weekly", Type.PERSONAL, "claening");
        MonthlyTask task7 = new MonthlyTask("Task #7 monthly", Type.WORK, "monthly report");
        YearlyTask task8 = new YearlyTask("Task #8 yearly", Type.WORK, "");
        List<Task> tasks = new ArrayList<>();

        tasks.add(task1);
        if (!tasks.contains(task2)) tasks.add(task2);
        if (!tasks.contains(task3)) tasks.add(task3);
        if (!tasks.contains(task4)) tasks.add(task4);
        if (!tasks.contains(task5)) tasks.add(task5);
        if (!tasks.contains(task6)) tasks.add(task6);
        if (!tasks.contains(task7)) tasks.add(task7);
        if (!tasks.contains(task8)) tasks.add(task8);

        try (Scanner scanner = new Scanner(System.in)) {
            label:
            while (true) {
                printMenu1();
                System.out.print("Выберите пункт меню: ");
                if (scanner.hasNextInt()) {
                    int menu = scanner.nextInt();
                    switch (menu) {
                        case 1:
                            inputTask(scanner, tasks);
                            break;
                        case 2:
                            // todo: обрабатываем пункт меню 2 (удалить задачу)
                            break;
                        case 3:
                            // todo: обрабатываем пункт меню 3 (Получить задачу на указанный день)
                            break;
                        case 0:
                            break label;
                    }
                } else {
                    scanner.next();
                    System.out.println("Выберите пункт меню из списка!");
                }
            }
        }
        System.out.println(" *** итоговый список задач ежедневника: ***");
        for (Task task : tasks) System.out.println(task);

    }

    private static void inputTask(Scanner scanner, List<Task> tasks) {
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

//            if (tasks.contains(task9))tasks.add(task9);
    }


    private static void printMenu1() {
        System.out.println("\n1. Добавить задачу\n2. Удалить задачу\n3. Получить задачу на указанный день\n0. Выход");

    }
}
