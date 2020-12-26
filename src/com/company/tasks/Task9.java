package com.company.tasks;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Нахождение вычета a^k(mod m) для простого и составного m
 */
public class Task9 {
    public void execute(int a, int b, int module) {
        System.out.println(String.format("Входные данные: %d^%d (mod %d)", a, b, module));

        if (isPrimeNumber(module)) {
            System.out.println(String.format("Число %d простое", module));
            calc(a, b, module);
        } else {
            System.out.println(String.format("Число %d составное", module));
            var fact = factorization(module);
            var system = new HashMap<Integer, List<Integer>>();
            for (var val : fact) {
                if (system.get(calc(a, b, val)) == null) {
                    system.put(calc(a, b, val), List.of(val));
                } else {
                    system.get(calc(a, b, val)).add(val);
                }
            }
            System.out.println("Получилась система");
            for (var s : system.keySet()) {
                System.out.println(String.format("x = %d (mod%d)", system.get(s).get(0), system.get(s).get(1)));
            }
            System.out.println(String.format("Решение: %d^%d (mod %d) = ", a, b, module) +
                    String.format("%d (mod %d)", calc(a, b, module), module));
        }
    }

    public static List<Integer> factorization(int m) {
        var list = new ArrayList<Integer>();
        int c = 1;
        for (int i = 1; i <= m; i++) {
            if (m % i == 0) {
                for (int k = 2; k < i; k++) {
                    if (i % k == 0) {
                        c = 1;
                        break;
                    } else {
                        c = 0;
                    }
                }
                if (c == 0 || i == 2) {
                    list.add(i);
                }
            }
        }

        return list;
    }

    public static Map<Integer, Integer> factorization1(int x) {
        Map<Integer, Integer> factors = new HashMap<>();

        for (int i = 2; i <= Math.sqrt(x); i++) {
            while (x % i == 0) {
                if (factors.get(i) == null) {
                    factors.put(i, 1);
                } else {
                    factors.put(i, factors.get(i) + 1);
                }
                x /= i;
            }
        }

        if (x != 1) {
            if (factors.get(x) == null) {
                factors.put(x, 1);
            } else {
                factors.put(x, factors.get(x) + 1);
            }
        }

        return factors;
    }

    private int calc(int a, int b, int module) {
        System.out.println(String.format("Расчет для %d^%d (mod %d)", a, b, module));
        var ost = b % (module - 1);
        int res = (int) (Math.pow(a, ost) % module);
        System.out.println(String.format("Результат: %d^%d (mod %d) = %d", a, ost, module, res));
        return res;
    }

    public static boolean isPrimeNumber(int number) {
        BigInteger bigInteger = BigInteger.valueOf(number);
        return bigInteger.isProbablePrime((int) Math.log(number));
    }
}
