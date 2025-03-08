import java.util.ArrayList;

public class Calculator {
    private ArrayList<String> history = new ArrayList<>();

    // Метод для сложения
    public double add(double a, double b) {
        double result = a + b;
        history.add(a + " + " + b + " = " + result);
        return result;
    }

    // Метод для вычитания
    public double subtract(double a, double b) {
        double result = a - b;
        history.add(a + " - " + b + " = " + result);
        return result;
    }

    // Метод для умножения
    public double multiply(double a, double b) {
        double result = a * b;
        history.add(a + " * " + b + " = " + result);
        return result;
    }

    // Метод для деления
    public double divide(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("Деление на ноль невозможно.");
        }
        double result = a / b;
        history.add(a + " / " + b + " = " + result);
        return result;
    }

    public double power(double base, double exponent) {
        double result = Math.pow(base, exponent);
        history.add(base + " ^ " + exponent + " = " + result);
        return result;
    }

    // Метод для вычисления квадратного корня
    public double squareRoot(double a) {
        if (a < 0) {
            throw new IllegalArgumentException("Квадратный корень из отрицательного числа невозможен.");
        }
        double result = Math.sqrt(a);
        history.add("√" + a + " = " + result);
        return result;
    }

    // Метод для показа истории операций
    public void showHistory() {
        if (history.isEmpty()) {
            System.out.println("История пуста.");
        } else {
            System.out.println("История операций:");
            for (String record : history) {
                System.out.println(record);
            }
        }
    }

    // Метод для очистки истории
    public void clearHistory() {
        history.clear();
        System.out.println("История очищена.");
    }

    public static long factorial(int n) {
        if (n < 0) {
            System.out.println("Факториал определён только для неотрицательных чисел.");
            return -1;
        }
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static void trigonometry(double angleInDegrees) {
        double angleInRadians = Math.toRadians(angleInDegrees);
        System.out.println("Синус: " + Math.sin(angleInRadians));
        System.out.println("Косинус: " + Math.cos(angleInRadians));
        System.out.println("Тангенс: " + Math.tan(angleInRadians));
    }

    public static void inverseTrigonometry(double value) {
        if (value < -1 || value > 1) {
            System.out.println("Значение должно быть в диапазоне от -1 до 1 для arcsin и arccos.");
            return;
        }
        System.out.println("arcsin: " + Math.toDegrees(Math.asin(value)));
        System.out.println("arccos: " + Math.toDegrees(Math.acos(value)));
        System.out.println("arctan: " + Math.toDegrees(Math.atan(value)));
    }

    public static void logarithm(double number) {
        if (number <= 0) {
            System.out.println("Логарифм определён только для положительных чисел.");
            return;
        }
        System.out.println("Натуральный логарифм (ln): " + Math.log(number));
        System.out.println("Десятичный логарифм (log10): " + Math.log10(number));
    }

    public static void absoluteValue(double number) {
        System.out.println("Модуль числа: " + Math.abs(number));
    }



}
