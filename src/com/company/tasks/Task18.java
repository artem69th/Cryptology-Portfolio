package com.company.tasks;

import java.math.BigInteger;

public class Task18 {

    public void execute() {
        //Квадратичный конгруэнтный генератор
        //Были выбраны след. параметры
        //𝑋0= 1, a=10946, b=196418, c=9227465, m=999983
        //Для хорошего генератора m – должно быть простым числом и достаточно большим! Делиться только она себя,
        // что бы можно было использовать остаток от деления.
        //Коэффициенты a,b,c были выбраны из последовательности Фибоначчи, при этом, a, b – четные числа, с – нечетное.

        //Было сгенерировано 100 чисел, которые не разу не повторились.
        //Начало последовательности:
        BigInteger x = BigInteger.valueOf(1);
        BigInteger a = BigInteger.valueOf(10946);
        BigInteger b = BigInteger.valueOf(196418);
        BigInteger c = BigInteger.valueOf(9227465);
        BigInteger m = BigInteger.valueOf(999983);

        for (int i = 0; i < 100; i++) {
            x = a.multiply(x).pow(x.intValue()).add(b.multiply(x)).add(c).mod(m);
            System.out.println(x);
        }
    }
}
