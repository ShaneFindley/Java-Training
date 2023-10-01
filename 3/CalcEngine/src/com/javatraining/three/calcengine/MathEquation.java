package com.javatraining.three.calcengine;

public class MathEquation {
    private MathOperation opCode;
    private double leftVal;
    private double rightVal;

    private double result;

    private static int numberOfCalculations;
    private static double sumOfResults;

    public MathEquation() {
    }

    public MathEquation(MathOperation opCode) {
        this.opCode = opCode;
    }

    public MathEquation(MathOperation opCode, double leftVal, double rightVal) {
        this(opCode);
        this.leftVal = leftVal;
        this.rightVal = rightVal;
    }

    public static double getAverageResult() {
        return sumOfResults / numberOfCalculations;
    }

    public MathOperation getOpCode() {
        return this.opCode;
    }

    public void setOpCode(MathOperation value) {
        this.opCode = value;
    }

    public double getLeftVal() {
        return this.leftVal;
    }

    public void setLeftVal(double value) {
        this.leftVal = value;
    }

    public double getRightVal() {
        return this.rightVal;
    }

    public void setRightVal(double value) {
        this.rightVal = value;
    }

    public double getResult() {
        return this.result;
    }

    public void execute() {
        switch (opCode) {
            case ADD:
                result = leftVal + rightVal;
                break;
            case SUBTRACT:
                result = leftVal - rightVal;
                break;
            case MULTIPLY:
                result = leftVal * rightVal;
                break;
            case DIVIDE:
                result = rightVal != 0 ? leftVal / rightVal : 0.0d;
                break;
            default:
                System.out.println("Invalid opCode " + opCode);
                result = 0.0d;
                break;
        }

        ++numberOfCalculations;
        sumOfResults += result;
    }

    public void execute(double leftVal, double rightVal) {
        this.leftVal = leftVal;
        this.rightVal = rightVal;
        execute();
    }

    public void execute(int leftVal, int rightVal) {
        this.leftVal = leftVal;
        this.rightVal = rightVal;
        execute();

        result = (int)result;
    }

    @Override
    public String toString() {
        char symbol = this.opCode.getSymbol();
        StringBuilder builder = new StringBuilder(20);
        builder.append(this.leftVal);
        builder.append(" ");
        builder.append(symbol);
        builder.append(" ");
        builder.append(this.rightVal);
        builder.append(" = ");
        builder.append(this.result);
        return builder.toString();
    }
}
