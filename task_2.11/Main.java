/*
Задание: Дан массив с числами. Узнайте сколько элементов с начала массива надо сложить, чтобы в сумме получилось больше 10-ти.
*/


public class Main {
    public static void main(String[] args) {
        //напишите тут ваш код
        int[] array = {1, 2, 3, 4, 3, 6, 5, 7, 8, 10};
        int count = 0;
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (sum > 10) {
                break;
            } else {
                sum += array[i];
                count++;
            }
        }
        System.out.println(count);
    }
}
