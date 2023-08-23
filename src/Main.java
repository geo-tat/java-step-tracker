import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();

        printMenu();
        int userInput = scanner.nextInt();
        int day = 0;

        while (userInput != 0) {

            if(userInput == 1) {
                System.out.println("Укажите номер месяца (1-12)");
                int month = scanner.nextInt();
                System.out.println("Укажите день (1-30)");
                day = scanner.nextInt();
                System.out.println("Укажите количество шагов");
                int steps = scanner.nextInt();
                if (month>0 & month <13 & day>0 & day<31 & steps>=0) {
                    stepTracker.stepsForDay(month, day, steps);
                }
                else {
                    System.out.println("Вы ввели данные с ошибкой. Попробуйте пожалуйста снова.");

                }
            } else if(userInput == 2) {
                System.out.println("Укажите номер месяца (1-12)");
                int month = scanner.nextInt();
                if (month>0 & month<13) {
                    stepTracker.allStepsForMonth(month);
                    stepTracker.sumAllSteps(month);
                    stepTracker.maxSteps(month);
                    stepTracker.averageSteps(month);
                    stepTracker.kmDist(month);
                    stepTracker.bestSeries(month);
                }
                else {
                    System.out.println("Такого месяца не существует.");
                }
            } else if(userInput == 3) {
                System.out.println("Ведите новую цель");
                int stepGoal = scanner.nextInt();
                stepTracker.changeGoalStep(stepGoal);
            } else {
                System.out.println("Извините, но такой команды нет");
            }

            printMenu();
            userInput = scanner.nextInt();
        }
        System.out.println("Программа завершена");

    }

    private static void printMenu() {
        System.out.println("Выберите действие:");
        System.out.println("1 - Ввести количество шагов за определенный день");
        System.out.println("2 - Напечатать статистику за определённый месяц");
        System.out.println("3 - Изменить цель по количеству шагов в день");
        System.out.println("0 - Выйти из приложения");
    }
}
