package com.company.tasks;

import com.company.enums.Euclid;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Решение системы сравнений китайским алгоритмом
 */
public class Task8 {
    public void execute(List<List<Integer>> numbersList) {
        for (var list : numbersList) {
            System.out.println(String.format("x ≡ %d mod(%d)", list.get(0), list.get(1)));
        }

        var M = 1;
        for (var list1 : numbersList) {
            M *= list1.get(1);
            for (var list2 : numbersList) {
                var eq = new Task2().execute(list1.get(1), list2.get(1), Euclid.NOD);
                if (eq.size() == 1 && eq.get(0) != 1) {
                    System.out.println("Модули попарно не взаимно простые => cистема не имеет решение");
                    return;
                }
            }
        }
        System.out.println("Модули попарно взаимно простые, тогда система имеет единственное решение");

        // составим сравнения
        var x0 = 0;
        for (var list : numbersList) {
            var y = podbor(M / list.get(1), 1, list.get(1));
            x0 += M / list.get(1) * y * list.get(0);
        }

        var count = 1;

        while (true) {
            var tmp = M * count;
            if (x0 - tmp > M) {
                count += 1;
            } else {
                x0 -= tmp;
                break;
            }
        }

        System.out.println(String.format("x ≡ %d (mod %d)", x0, M));
    }

    private int podbor(int a, int b, int c) {
        var list = IntStream.range(1, c).boxed().collect(Collectors.toList());
        for (var i : list) {
            if (((a * i) - b) % c == 0) {
                return i;
            }
        }
        return 0;
    }
}
