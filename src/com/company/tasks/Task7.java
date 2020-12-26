package com.company.tasks;

import com.company.enums.Euclid;

import java.util.List;

/**
 * Решение сравнений
 */
public class Task7 {
    public List<Integer> execute(int a, int b, int m) {
        System.out.println(String.format("%dx ≡ %d (mod %d)", a, b, m));
        var euclidList = new Task2().execute(a, m, Euclid.NOD_X_Y);
        var nod = euclidList.get(0);
        var x = euclidList.get(1);

        if (nod == 1) {
            System.out.println("В данном случае 1 решение");
            return List.of(x, m);
        } else if (nod > 1) {
            if (b % nod == 0) {
                System.out.println(String.format("В данном случае %d решений", nod));
                var mod = m;
                a = a / nod;
                b = b / nod;
                m = m / nod;
                b = help(a, b, m);
                b = b / a;
                System.out.println(String.format("x ≡ %d + %d*k (mod %d), где k ∈ от 1 до %d", b, m, mod, m));
                return List.of();
            } else {
                System.out.println("В данном случае нет решений");
                return List.of();
            }
        }
        return List.of();
    }

    private int help(int a, int b, int m) {
        var c = 1;
        while (true) {
            var tmp = b + m * c;
            c += 1;
            if (tmp % a == 0) {
                return tmp;
            }
        }
    }
}



