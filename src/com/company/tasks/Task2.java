package com.company.tasks;

import com.company.enums.Euclid;

import java.util.List;

/**
 * Линейное разложение НОД по расширенному алгоритму Эвклида
 */
public class Task2 {
    public List<Integer> execute(int firstValue, int secondValue, Euclid euclid) {
        if (firstValue == secondValue) {
            return List.of(1);
        }

        var f = firstValue;
        var l = secondValue;
        var x_pprev = 1;
        var x_prev = 0;
        System.out.println(String.format("НОД: %d %d", firstValue, secondValue));
        var q = firstValue / secondValue;
        var x = x_pprev - q * x_prev;

        while (firstValue % secondValue != 0) {
            var t = secondValue;
            q = firstValue / secondValue;
            secondValue = firstValue % secondValue;
            firstValue = t;
            x = x_pprev - q * x_prev;
            x_pprev = x_prev;
            x_prev = x;
            System.out.println(String.format("r=%d \t q=%d \t x=%d", secondValue, q, x));
        }

        var y = (secondValue - f * x_prev) / l;
        System.out.println(String.format("Результат: r=%d \t q=%d \t x=%d \t y=%d\n", secondValue, q, x, y));
        var nod = x * f + y * l;

        if (y * l < 0) {
            System.out.println(String.format("Линейное разложение НОД: (%d,%d)=%d%d=%d", f, l, x * f, y * l, nod));
        } else {
            System.out.println(String.format("Линейное разложение НОД: (%d,%d)=%d+%d=%d", f, l, x * f, y * l, nod));
        }

        switch (euclid) {
            case NOD_X:
                return List.of(secondValue, x);
            case NOD_X_Y:
                return List.of(secondValue, x, y);
            default:
                return List.of(secondValue);
        }
    }
}
