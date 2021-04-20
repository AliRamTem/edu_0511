/*
1. Ввести путь к файлу с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
-2
11
3
-5
2
10
Пример вывода:
-2
2
8
10
*/

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        // напишите тут ваш код
        Set<Integer> set = new TreeSet<>();
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();
        FileReader fileReader;
        try {
            fileReader = new FileReader(path);
            scanner = new Scanner(fileReader);
            while (scanner.hasNext()) {
                int i = scanner.nextInt();
                if (i % 2 == 0) {
                    set.add(i);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(set);

    }
}
