/*
ВНИМАНИЕ эта задача для ДЗ и не является обязательной.
Задание: 1. Создай массив чисел.
2. Добавь в массив 10 чисел с клавиатуры.
3. Вывести на экран длину самой длинной последовательности повторяющихся чисел в списке.
Пример для списка 2, 4, 4, 4, 8, 8, 4, 12, 12, 14:
3
*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //напишите тут ваш код
        int[] array = new int[10];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < array.length; i++) {
            array[i] = sc.nextInt();
        }
        int maxCount = 1;
        int count = 1;
        for (int i = 1; i < array.length; i++) {
            if (array[i] == array[i - 1]) {
                count++;
            } else {
                if (count > maxCount) {
                    maxCount = count;
                    count = 1;
                }
            }
        }
        if (count > maxCount) {
            maxCount = count;
        }
        System.out.println(maxCount);
    }
}
