package com.company.tasks;

import java.util.HashMap;

/**
 * Каноническое разложение числа на простые множители
 */
public class Task4 {
    public HashMap<Integer, Integer> execute(int number) {
        System.out.println("Каноническое разложение числа " + number + " на простые множители:");

        var i = 2;
        var numbers = new HashMap<Integer, Integer>();
        while (i * i <= number) {
            while (number % i == 0) {
                numbers.put(i, numbers.get(i) == null ? 1 : numbers.get(i) + 1);
                number = number / i;
            }
            i = i + 1;
        }
        if (number > 1) {
            numbers.put(number, numbers.get(number) == null ? 1 : numbers.get(number) + 1);
        }

        for (var r : numbers.keySet()) {
            System.out.print(r + " ");
        }
        return numbers;
    }
}
