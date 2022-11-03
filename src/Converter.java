public class Converter {
    double lengthStep = 0.75;
    double caloriesStep = 50;


    public void converter(int steps) {
        System.out.println("Пройденная дистанция (в км) = " + (steps * lengthStep / 1000));
        System.out.println("Колличество сожженых килокаллорий = " + (steps * caloriesStep / 1000));
    }
}
