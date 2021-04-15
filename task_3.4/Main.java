/*
Задание: Сделайте функцию, которая параметрами принимает 2 числа. Если их сумма больше 10 - пусть функция вернет true, а если нет - false.
*/


public class Main {
    public static void main(String[] args) {
        //напишите тут ваш код
        System.out.println(moreThenTen(1, 2));
        System.out.println(moreThenTen(1, 9));
        System.out.println(moreThenTen(-10, 20));
        System.out.println(moreThenTen(-1, -2));
        System.out.println(moreThenTen(11, 2));
    }

    private static boolean moreThenTen(int a, int b) {
        return a + b > 10;
    }
}
