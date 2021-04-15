/*
Задание: Дан массив с числами. Проверьте, что в этом массиве есть число 5. Если есть - выведите 'да', а если нет - выведите 'нет'.
*/

import jdk.swing.interop.SwingInterOpUtils;

public class Main {
    public static void main(String[] args) {
        //напишите тут ваш код
        int[] array = {1, 2, 3, 4, 3, 6, 7, 7, 8, 10};
        boolean has = false;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 5) {
                has = true;
                break;
            }
        }
        if (has) {
            System.out.println("да");
        } else {
            System.out.println("нет");
        }
    }
}
