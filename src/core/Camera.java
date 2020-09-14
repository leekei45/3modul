package core;

public class Camera {
    public static Car getNextCar() {
        String randomNumber = Double.toString(Math.random()).substring(2, 5);
        int randomHeight = (int) (1000 + 3500. * Math.random());  // Переменная типа int - целые числа
        double randomWeight = 600 + 10000 * Math.random(); //    Переменная типа double - дробные числа

        Car car = new Car();
        car.setNumber(randomNumber);
        car.setHeight(randomHeight);
        car.setWeight(randomWeight);
        car.setHasVehicle(Math.random() > 0.5);
        car.setIsSpecial(Math.random() < 0.15);

        return car;
    }
}