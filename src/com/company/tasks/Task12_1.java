package com.company.tasks;

public class Task12_1 {
    public static void main(String[] args) {
        int a = 126;
        int p = 10;

        int minus = 1;

        System.out.print("a = " + a + " p = " + p);
        if (a < 0) {
            a = a * (-1);
            if ((p - 1) / 2 % 2 == 1) {
                minus = -1;
            }
        }
        if (p == 10) {
            return;
        }
    }

    //  Compute (k n), where k is numerator
    private static int jacobiSymbol(int k, int n) {
        if (k < 0 || n % 2 == 0) {
            throw new IllegalArgumentException("Invalid value. k = " + k + ", n = " + n);
        }
        k %= n;
        int jacobi = 1;
        while (k > 0) {
            while (k % 2 == 0) {
                k /= 2;
                int r = n % 8;
                if (r == 3 || r == 5) {
                    jacobi = -jacobi;
                }
            }
            int temp = n;
            n = k;
            k = temp;
            if (k % 4 == 3 && n % 4 == 3) {
                jacobi = -jacobi;
            }
            k %= n;
        }
        if (n == 1) {
            return jacobi;
        }
        return 0;
    }
}
