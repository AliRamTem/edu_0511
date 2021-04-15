/*
Задание: Дан массив с числами. Выведите последовательно его элементы используя рекурсию и не используя цикл.
*/


public class Main {
    public static void main(String[] args) {
        int num[] = {};
        print(num, 0);
    }

    private static void print(int[] num, int i) {
        if (num.length != 0) System.out.println(num[i]);
        if (i < num.length - 1) {
            print(num, ++i);
        }
    }

}
