/*
Задание: Дано число, например 31. Проверьте, что это число не делится ни на одно другое число кроме себя самого и единицы. То есть в нашем случае нужно проверить, что число 31 не делится на все числа от 2 до 30. Если число не делится - выведите 'false', а если делится - выведите 'true'.
*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //напишите тут ваш код
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        if (isNatural(a)) {
            System.out.println("false");
        } else {
            System.out.println("true");
        }
    }

    private static boolean isNatural(int a) {
        for (int i = 2; i < a - 1; i++) {
            if (a % i == 0)
                return true;
        }
        return false;
    }
}
