package com.javatraining.three.calcengine;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            performCalculations();
        } else if (args.length == 1 && args[0].equals("interactive")) {
            executeInteractively();
        } else if (args.length == 3) {
            performOperation(args);
        } else {
            System.out.println("The number of arguments is incorrect");
        }

    }

    static void performCalculations() {
        MathEquation[] equations = new MathEquation[4];
        equations[0] = new MathEquation(MathOperation.DIVIDE, 100.0d, 50.0d);
        equations[1] = new MathEquation(MathOperation.ADD, 25.0d, 92.0d);
        equations[2] = new MathEquation(MathOperation.SUBTRACT, 225.0d, 17.0d);
        equations[3] = new MathEquation(MathOperation.MULTIPLY, 11.0d, 3.0d);

        /*
        for (int i = 0; i < opCodes.length; i++) {
            results[i] = execute(opCodes[i], leftVals[i], rightVals[i]);
        }
        */

        for (MathEquation equation : equations) {
            equation.execute();
            System.out.println(equation);
        }

        System.out.println("Average result = " + MathEquation.getAverageResult());

        useOverloads();
    }

    static void useOverloads() {
        System.out.println();
        System.out.println("Using execute overloads");
        System.out.println();

        MathEquation overloadedEquation = new MathEquation(MathOperation.DIVIDE);
        overloadedEquation.execute(9.0d, 4.0d);
        System.out.println("Overload result with doubles: " + overloadedEquation);
        overloadedEquation.execute(9, 4);
        System.out.println("Overload result with ints: " + overloadedEquation);
    }

    static void executeInteractively() {
        System.out.println("Enter an operation and two numbers");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        String[] parts = userInput.split(" ");
        performOperation(parts);
    }

    private static void performOperation(String[] parts) {
        MathOperation opCode = MathOperation.valueOf(parts[0].toUpperCase());
        double leftVal = valueFromWord(parts[1]);
        double rightVal = valueFromWord(parts[2]);
        MathEquation equation = new MathEquation(opCode, leftVal, rightVal);
        equation.execute();
        System.out.println(equation);
    }

    static double valueFromWord(String word) {
        boolean hadValue = false;
        String[] numberWords = {
            "zero", "one", "two", "three", "four",
            "five", "six", "seven", "eight", "nine"
        };
        double value = 0d;
        for (int i = 0; i < numberWords.length; i++) {
            if (word.equals(numberWords[i])) {
                value = i;
                hadValue = true;
                break;
            }
        }

        if (!hadValue)
            value = Double.parseDouble(word);

        return value;
    }
}
