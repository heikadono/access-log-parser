import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите первое число:");
        int firstNumber = new Scanner(System.in).nextInt();
        System.out.println("Введите второе число:");
        int secondNumber = new Scanner(System.in).nextInt();

        int sum = firstNumber + secondNumber;
        int difference = firstNumber - secondNumber;
        int composition = firstNumber * secondNumber;
        double qoutient = (double) firstNumber / secondNumber;

        System.out.println("Результат вычеслений:");
        System.out.println("Сумма: " + sum + ", разность: " + difference + ", произведение: " + composition + ", частное: " + qoutient + ";");
    }
}
