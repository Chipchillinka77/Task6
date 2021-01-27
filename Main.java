package com.company;

import java.io.PrintStream;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    static PrintStream out = System.out;


    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);
        Scanner in = new Scanner(System.in);
        out.print("Введите x, n и e:");
        double x = in.nextDouble();
        int n = in.nextInt();
        double e = in.nextDouble();
        double[] sum = sum1(n, x, e);
        out.printf("Сумма n слагаемых: %f",sum[0]);
        out.println();
        out.printf("Сумма слагаемых, которые по абсолютной величине больше e: %f",sum[1]);
        out.println();
        out.printf("Сумма слагаемых, которые по абсолютной величине больше e/10: %f",sum[2]);
        out.println();
        out.printf("Значение функции с помощью методов Math: %f", mathSum(x));

    }

    public static double factorial(int n, int prevN, double prev) {
        for (int i = prevN + 1; i <= n; i++) {
            prev = prev * i;

        }
        return prev;
    }

    public static double factorialByN(int n) {
        double res = 1;
        if (n == 0) {
            return res;
        }
        for (int i = 1; i <= n; i++) {
            res = res * i;
        }
        return res;
    }

    public static double[] sum1(int n, double x, double e) {
        double current = 1;
        double fact = factorialByN(3);
        int a = -1;
        double resN = 1, resE = 1, resE10 = 1, resTmp = 1;
        int factCount = 3;
        double x1 = x * x;
        x = x1;
        for (int i = 1; i <= n || Math.abs(current) > e; i++) {
             current = a * x / fact;
            resTmp += current;
            if (Math.abs(current) > e) {
                resE = resTmp;
            }
            if (Math.abs(current) > e / 10) {
                resE10 = resTmp;
            }
            if (i <= n) {
                resN = resTmp;
            }
            a = a * (-1);
            x *= x1;
            fact = factorial(factCount + 2, factCount, fact);
            factCount += 2;
        }
        return new double[]{resN, resE, resE10};
    }

    public static double mathSum(double x) {
        return Math.sin(x) / x;
    }
}
