package com.company.tasks;

/**
 * Расчет функции Эйлера
 */
public class Task5 {
    public void execute(int number) {
        var dictFact = new Task4().execute(number);
        var result = 1;
        for (var key : dictFact.keySet()) {
            int one = (int) Math.pow(key, dictFact.get(key));
            int two = (int) Math.pow(key, dictFact.get(key) - 1);
            result = result * (one - two);
        }
        System.out.println(String.format("\n%s = %d", "Функция Эйлера", result));
    }
}
