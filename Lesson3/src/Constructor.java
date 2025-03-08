class Car1 {
    String brand;
    int maxSpeed;

    // Конструктор класса Car
    public Car1(String brand, int maxSpeed) {
        this.brand = brand;      // устанавливаем марку машины
        this.maxSpeed = maxSpeed; // устанавливаем максимальную скорость
//        brand = "Unknown";  // по умолчанию марка будет Unknown
//        maxSpeed = 0;       // по умолчанию максимальная скорость будет 0
    }

    // Конструктор только с параметром марка
    public Car1(String brand) {
        this.brand = brand;
        this.maxSpeed = 100;  // если не указана скорость, ставим 100
    }

    void drive() {
        System.out.println(brand + " едет со скоростью до " + maxSpeed + " км/ч.");
    }
}

//public class Main {
//    public static void main(String[] args) {
//        // Создаём объект Car с использованием конструктора
//        Car1 myCar = new Car1("Toyota", 180);
//        myCar.drive(); // Toyota едет со скоростью до 180 км/ч.

////        Создаём машину с одним параметром
//         Car myCar2 = new Car("Honda");
//        myCar2.drive(); // Honda едет со скоростью до 100 км/ч.
//    }
//}
