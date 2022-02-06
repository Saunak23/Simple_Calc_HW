package com.example.simple_calchw;

public class Calculator {

    public enum Operator {ADD, SUB, DIV, MUL, POW}

    public double addition(double firstOperand, double secondOperand) {
        return firstOperand + secondOperand;
    }

    public double subtraction(double firstOperand, double secondOperand) {
        return firstOperand - secondOperand;
    }

    public double division(double firstOperand, double secondOperand) {
        return firstOperand / secondOperand;
    }

    public double multiplication(double firstOperand, double secondOperand) {
        return firstOperand * secondOperand;
    }

    public double power(double firstOperand, double secondOperand) {
        return Math.pow(firstOperand, secondOperand);
    }
}