package com.company.tasks;

import java.util.Arrays;

/**
 * Поиск простых чисел до числа n (с помощью алгоритмов, которые вы готовили на доклады)
 * Алгоритм Аткина
 */
public class Task3 {
    private static int LIMIT = 10000000;
    private static int LIMIT_SQRT = (int) Math.sqrt(LIMIT);
    private static boolean[] SIEVE = new boolean[LIMIT];

    public void execute() {
        System.out.println("Решето Аткина");
        // инициализируем каждый элемент массива false'ом
        Arrays.fill(SIEVE, false);

        // 2, 3 - заведомо простые числа
        SIEVE[2] = true;
        SIEVE[3] = true;

        long startTime = System.currentTimeMillis();

        // ищем простые числа
        for (int x = 1; x <= LIMIT_SQRT; x++) {
            for (int y = 1; y <= LIMIT_SQRT; y++) {
                checkNumber(x, y);
            }
        }

        // избавляемся от чисел, кратных квадрату простого числа
        for (int n = 5; n <= LIMIT_SQRT; n++) {
            if (SIEVE[n]) {
                int x = n * n;
                for (int i = x; i < LIMIT; i += x) {
                    if (SIEVE[i]) {
                        SIEVE[i] = false;
                    }
                }
            }
        }

        var endTime = System.currentTimeMillis();

        // вывод на экран
        int count = 0;
        for (int i = 0, j = 0; i < LIMIT; i++) {
            if (SIEVE[i]) {
                System.out.printf("[%,8d]", i);
                count++;
                if (++j % 10 == 0) {
                    System.out.println();
                }
            }
        }

        System.out.println("\nSimple numders count: " + count);
        System.out.println("\nExecution time: " + (endTime - startTime) + "ms");
    }

    private static void checkNumber(int x, int y) {
        // n = 4x2 + y2
        int n = (4 * x * x) + (y * y);
        if (n < LIMIT && (n % 12 == 1 || n % 12 == 5)) {
            SIEVE[n] = !SIEVE[n];
        }

        // n = 3x2 + y2
        n = (3 * x * x) + (y * y);
        if (n < LIMIT && (n % 12 == 7)) {
            SIEVE[n] = !SIEVE[n];
        }

        // n = 3x2 - y2, если x > y
        n = (3 * x * x) - (y * y);
        if (x > y && n < LIMIT && (n % 12 == 11)) {
            SIEVE[n] = !SIEVE[n];
        }
    }
}

//    LIMIT             Кол-во простых чисел
//    10                4
//    100               25
//    1 000             168
//    10 000            1 229
//    100 000           9 592
//    1 000 000         78 498
//    10 000 000        664 579
//    100 000 000       5 761 455
//    1 000 000 000     50 847 534
//    10 000 000 000    455 052 512