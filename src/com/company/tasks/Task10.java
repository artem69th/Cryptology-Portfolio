package com.company.tasks;

import static com.company.tasks.Task9.factorization;
import static com.company.tasks.Task9.isPrimeNumber;

/**
 * Нахождение первообразного корня (образующего элемента) и формирование с его помощью приведенной системы вычетов
 */
public class Task10 {
    public void execute(int m) {
        System.out.println("Найдем первообразный корень для числа " + m);

        var degree = m;

        if (isPrimeNumber(degree) && degree % 2 != 0) {
            degree -= 1;
        } else {
            System.out.println("Число не является простым или четным");
            return;
        }

        var primitive = getPrimitive(degree, m);

        System.out.println("Сформируем приведенную систему вычетов:");
        var d = 0;

        while (d != degree) {
            var res = (int) Math.pow(primitive, d) % m;
            System.out.println(String.format("%d^%d ≡ %d (mod %d)", primitive, d, res, m));
            d += 1;
        }
    }

    private int getPrimitive(int degree, int m) {
        var fact = factorization(degree);
        for (var number : fact) {
            for (var n : fact) {
                if (Math.pow(number, degree / n) % m == 1) {
                    break;
                } else {
                    System.out.println("Первообразный корень = " + number);
                    return number;
                }
            }
        }
        return 0;
    }
}
