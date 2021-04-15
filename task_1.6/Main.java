/*
Пользователь вводит число, необходимо увеличить это число на 15% и вывести результат на экран
*/

public class Main {
    public static void main(String[] args) {
        // Ваш код
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        double result = input + input * .15;
        System.out.println(result);
    }
}
