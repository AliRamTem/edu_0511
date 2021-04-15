/*
Задание: Пользователь вводит сумму вклада и процент, который будет начисляться ежегодно. Отобразить размер вклада поочередно на ближайшие 5 лет.
*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //напишите тут ваш код
        Scanner sc = new Scanner(System.in);
        double balance = sc.nextDouble();
        double percent = sc.nextDouble();

        for (int i = 0; i < 5; i++) {
            balance = balance * percent / 100 + balance;
            System.out.println(balance);
        }
    }
}
