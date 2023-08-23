public class StepTracker {
    int stepGoal = 10000;
    MonthData[] monthToData;

    public StepTracker() {
        monthToData = new MonthData[12];
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    public void stepsForDay(int month, int day, int steps) {
        MonthData monthToPut = monthToData[month];
        monthToPut.days[day - 1] = steps;
    }

    void changeGoalStep(int stepGoal) {
        if (stepGoal > 0) {
            this.stepGoal = stepGoal;
            System.out.println("Сейчас цель: " + this.stepGoal);
        } else {
            System.out.println("Данная цель не осуществима");
        }

    }

    public void allStepsForMonth(int month) {
        MonthData allStepsForMonth = monthToData[month];
        for (int i = 0; i < allStepsForMonth.days.length; i++) {
            if (i < 29) {
                System.out.print((i + 1) + " день: " + allStepsForMonth.days[i] + ", ");
            } else {
                System.out.println((i + 1) + " день: " + allStepsForMonth.days[i] + ". ");
            }
        }
    }

    public void sumAllSteps(int month) {
        int sum = 0;
        MonthData sumAllSteps = monthToData[month];
        for (int i = 0; i < sumAllSteps.days.length; i++) {
            sum = sum + sumAllSteps.days[i];
        }
        System.out.println("Общее количество шагов за месяц: " + sum);
    }

    public void maxSteps(int month) {
        int max = 0;
        MonthData maxSteps = monthToData[month];
        for (int i = 0; i < maxSteps.days.length; i++)
            if (maxSteps.days[i] > max) {
                max = maxSteps.days[i];
            }
        System.out.println(max + " - максимальное количество шагов за день в этом месяце.");
    }

    public void averageSteps(int month) {
        double average = 0;
        int sum = 0;
        MonthData averageSteps = monthToData[month];
        for (int i = 0; i < averageSteps.days.length; i++) {
            sum = sum + averageSteps.days[i];
        }
        average = sum / averageSteps.days.length;
        System.out.println(average + " - среднее количество шагов за день в этом месяце.");
    }

    public void kmDist(int month) {
        MonthData kmDist = monthToData[month];
        Converter convert = new Converter();
        int steps = 0;
        for (int i = 0; i < kmDist.days.length; i++) {
            steps = steps + kmDist.days[i];
        }
        convert.converter(steps);
    }

    public void bestSeries(int month) {
        MonthData bestSeries = monthToData[month];
        int count = 0;
        int maxCount = 0;
        for (int i = 0; i < bestSeries.days.length; i++) {
            if (bestSeries.days[i] >= stepGoal) {
                count = count + 1;
                if (maxCount < count) {
                    maxCount = count;
                }
            } else {
                count = 0;
            }
        }
        System.out.println("Лучшая серия - " + maxCount + " дней.");
    }


    class MonthData {
        int[] days = new int[30];
    }
}
