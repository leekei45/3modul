import core.*;
import core.Camera;

import java.util.Scanner;

public class RoadController {
    private static double passengerCarMaxWeight = 3500.0; // kg   Переменная типа double - дробные числа
    private static int passengerCarMaxHeight = 2000; // mm        Переменная типа int - целые числа
    private static int controllerMaxHeight = 4000; // mm          Переменная типа int - целые числа

    private static int passengerCarPrice = 100; // RUB            Переменная типа int - целые числа
    private static int cargoCarPrice = 250; // RUB                Переменная типа int - целые числа
    private static int vehicleAdditionalPrice = 200; // RUB       Переменная типа int - целые числа

    public static void main(String[] args) {
        System.out.println("Сколько автомобилей сгенерировать?");

        Scanner scanner = new Scanner(System.in);      // Переменная типа int - целые числа
        int carsCount = scanner.nextInt();             // Переменная типа int - целые числа

        for (int i = 0; i < carsCount; i++) {          // Переменная типа int - целые числа
            Car car = Camera.getNextCar();
            System.out.println(car);

            //Пропускаем автомобили спецтранспорта бесплатно
            if (car.isSpecial) {
                openWay();
                continue;
            }

            //Проверяем высоту и массу автомобиля, вычисляем стоимость проезда
            int price = calculatePrice(car);              // Переменная типа int - целые числа
            if (price == -1) {
                continue;
            }

            System.out.println("Общая сумма к оплате: " + price + " руб.");
        }
    }

    /**
     * Расчёт стоимости проезда исходя из массы и высоты
     */
    private static int calculatePrice(Car car) {
        int carHeight = car.height;            // Переменная типа int - целые числа
        int price = 0;                         // Переменная типа int - целые числа
        if (carHeight > controllerMaxHeight) {
            blockWay("высота вашего ТС превышает высоту пропускного пункта!");
            return -1;
        } else if (carHeight > passengerCarMaxHeight) {
            double weight = car.weight;    //    Переменная типа double - дробные числа
            //Грузовой автомобиль
            if (weight > passengerCarMaxWeight) {
                price = passengerCarPrice;
                if (car.hasVehicle) {
                    price = price + vehicleAdditionalPrice;
                }
            }
            //Легковой автомобиль
            else {
                price = cargoCarPrice;
            }
        } else {
            price = passengerCarPrice;
        }
        return price;
    }

    /**
     * Открытие шлагбаума
     */
    private static void openWay() {
        System.out.println("Шлагбаум открывается... Счастливого пути!");
    }

    /**
     * Сообщение о невозможности проезда
     */
    private static void blockWay(String reason) {
        System.out.println("Проезд невозможен: " + reason);
    }
}