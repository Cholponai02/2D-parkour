public class Car {
    String brand; // параметры
    int speed;
    int weight;

    public void drive(){ // метод
        System.out.println("Машина " + brand + " едет со скоростью " + speed);
    }

    public void perevozka(){ // метод
        System.out.println("Машина " + brand + " перевозит груз с весом " + weight);
    }

}
// Наследуемся от Car
// Легковой sedan
// Грузовой crossover

class Sedan extends Car{
    int passenger;
    public void showPassenger(){
        System.out.println("Перевозит " + passenger);
    }
}

class Crossover extends Car{
    int nameGruz;
    public void showGruz(){
        System.out.println("Перевозит " + nameGruz);
    }
}