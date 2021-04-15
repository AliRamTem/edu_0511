/*
Задание: Дан массив с числами. Проверьте, есть ли в нем два одинаковых числа подряд. Если есть - выведите 'да', а если нет - выведите 'нет'.
*/


public class Main {
    public static void main(String[] args) {
        //напишите тут ваш код
        int[] array = {1, 2, 3, 4, 3, 6, 5, 7, 8, 10};
        boolean has = false;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] == array[i + 1]) {
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
