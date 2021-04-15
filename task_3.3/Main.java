/*
Задание: Сделайте функцию, которая параметрами принимает 2 числа. Если эти числа равны - пусть функция вернет true, а если не равны - false.
*/


public class Main {
    public static void main(String[] args) {
        //напишите тут ваш код
        System.out.println(equally(5, 10));
        System.out.println(equally(5, 5));
        System.out.println(equally(0, 1));
        System.out.println(equally(-10, 10));
        System.out.println(equally(-1, -1));
    }

    private static boolean equally(int a, int b) {
        return a == b;
    }
}
