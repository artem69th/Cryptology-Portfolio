package com.company.tasks;

import java.util.List;

/**
 * Нахождение обратного элемента
 */
public class Task6 {
    public void execute(int number, int module) {
        var list = getNumbers(number, module);
        var g = list.get(0);
        var x = list.get(1);
        if (g == 1) {
            var res = x % module;
            if (res < 0) {
                res = module + res;
            }
            System.out.println(String.format("%s %d %s %d = %d","Обратный элемент к", number, "по модулю", module, res));
        }
    }

    private List<Integer> getNumbers(int number, int module) {
        if (number == 0) {
            return List.of(module, 0, 1);
        } else {
            var list = getNumbers(module % number, number);
            var q = list.get(0);
            var x = list.get(1);
            var y = list.get(2);
            return List.of(q, y - module / number * x, x);
        }
    }
}
