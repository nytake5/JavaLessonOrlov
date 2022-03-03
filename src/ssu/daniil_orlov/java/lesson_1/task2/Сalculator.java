package ssu.daniil_orlov.java.lesson_1.task2;

import java.util.Scanner;

public class Сalculator {

    public static void main(String[] args) {
        Сalculator calc = new Сalculator();
        calc.startApplication();
    }

    private void startApplication() {

        Scanner in = new Scanner(System.in);
        System.out.println("Please, entry two digits");
        System.out.print("x = ");
        int x = in.nextInt();
        System.out.print("y = ");
        int y = in.nextInt();
        System.out.println("Please choose move");
        switch (in.next()){
            case "+":
                System.out.println(Sum(x, y));
                break;
            case "-":
                System.out.println(Sub(x, y));
                break;
            case "*":
                System.out.println(Mul(x, y));
                break;
            case "/":
                System.out.println(Div(x, y));
                break;
            default:
                System.out.println("Try again!");
        }
    }

    private int Sum(int x, int y) {
        return x + y;
    }

    private int Sub(int x, int y) {
        return x - y;
    }

    private int Mul(int x, int y) {
        return x * y;
    }

    private float Div(int x, int y) {
        return (float) x / y;
    }
}
