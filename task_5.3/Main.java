/*
 * Задание: Дана коллекция с числами. Запишите в новую коллекцию только те числа, которые больше нуля и меньше 10-ти.
 * Коллекции вы создаёте сами
 */

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> firstList = new ArrayList<>();
        firstList.add(1);
        firstList.add(11);
        firstList.add(10);
        firstList.add(0);
        firstList.add(4);
        firstList.add(114);
        firstList.add(-21);

        List<Integer> secondList = new ArrayList<>();
        for (Integer i : firstList)
            if (i > 0 && i < 10)
                secondList.add(i);

        System.out.println(firstList);
        System.out.println(secondList);
    }
}
