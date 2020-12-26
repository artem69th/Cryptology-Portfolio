package com.company.tasks;

/**
 * Нахождение НОД по алгоритму Эвклида
 */
public class Task1 {
    public void execute(int firstValue, int secondValue) {
        var fv = firstValue;
        var sc = secondValue;
        System.out.println("Первое значение = " + firstValue);
        System.out.println("Второе значение = " + secondValue);
        while (firstValue != 0 && secondValue != 0) {
            if (firstValue > secondValue) {
                firstValue = firstValue % secondValue;
            } else {
                secondValue = secondValue % firstValue;
            }
        }
        var nod = firstValue + secondValue;
        System.out.println(String.format("%s(%d,%d) = %d", "НОД", fv, sc, nod));
    }
}
