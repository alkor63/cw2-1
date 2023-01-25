import CourseWork2code.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        LocalDate polisDate = LocalDate.of(2022,11,10);
        System.out.println("Input дата : "+polisDate);
        System.out.println("Текущая дата : "+LocalDateTime.now());

        OneTimeTask task1 = new OneTimeTask("Task #1 oneTime", Type.WORK,null);
        OneTimeTask task2 = new OneTimeTask("Task #2 oneTime", Type.PERSONAL,"Barbershop");
        OneTimeTask task3 = new OneTimeTask("Task #3 oneTime", Type.WORK," ");
        DailyTask task4 = new DailyTask("Task #4 dayly", Type.WORK,"Проверить почту");
        DailyTask task5 = new DailyTask("Task #5 dayly", Type.PERSONAL,"почистить зубы");
        WeeklyTask task6 = new WeeklyTask("Task #6 weekly", Type.PERSONAL,"claening");
        MonthlyTask task7 = new MonthlyTask("Task #7 monthly", Type.WORK,"monthly report");
        YearlyTask task8 = new YearlyTask("Task #8 yearly", Type.WORK,"");
        System.out.println(task1);
        System.out.println(task2);
        System.out.println(task3);
        System.out.println(task4);
        System.out.println(task5);
        System.out.println(task6);
        System.out.println(task7);
        System.out.println(task8);
        System.out.println(task1.appearsIn(polisDate));
/*
        try (Scanner scanner = new Scanner(System.in)) {
            label:
            while (true) {
                printMenu();
                System.out.print("Выберите пункт меню: ");
                if (scanner.hasNextInt()) {
                    int menu = scanner.nextInt();
                    switch (menu) {
                        case 1:
                            inputTask(scanner);
                            break;
                        case 2:
                            // todo: обрабатываем пункт меню 2
                            break;
                        case 3:
                            // todo: обрабатываем пункт меню 3
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
    }

    private static void inputTask(Scanner scanner) {
        System.out.print("Введите название задачи: ");
        String taskName = scanner.next();
        // todo
    }

    private static void printMenu() {
        System.out.println("1. Добавить задачу\n2. Удалить задачу\n3. Получить задачу на указанный день\n0. Выход");
*/
    }
}
