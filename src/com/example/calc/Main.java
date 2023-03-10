package com.example.calc;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        boolean roman = false;
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("I", 1);
        map.put("II", 2);
        map.put("III", 3);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("VI", 6);
        map.put("VII", 7);
        map.put("VIII", 8);
        map.put("IX", 9);
        map.put("X", 10);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input");
        String input = scanner.nextLine();
        String[] temp = input.split(" ");
        if (map.containsKey(temp[0]) & map.containsKey(temp[2])) {
            temp[0] = map.get(temp[0]).toString();
            temp[2] = map.get(temp[2]).toString();
            roman = true;
            System.out.println(temp[0] + " " + temp[2]);
        }
        int firstNumber = Integer.parseInt(temp[0]);
        int secondNumber = Integer.parseInt(temp[2]);
        if (firstNumber > 10 || firstNumber < 1 || secondNumber > 10 || secondNumber < 1) {
            throw new RuntimeException();
        }
        char operation = temp[1].charAt(0);
        int result = 0;
        switch (operation) {
            case '+':
                result = firstNumber + secondNumber;
                break;
            case '-':
                result = firstNumber - secondNumber;
                break;
            case '*':
                result = firstNumber * secondNumber;
                break;
            case '/':
                result = firstNumber / secondNumber;
                break;
            default:
                throw new RuntimeException();
        }
        if (roman == true & map.containsValue(result)) {
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (entry.getValue().equals(result)) {
                    System.out.println("Output \n" + entry.getKey());
                }
            }
        } else if (roman == false) {
            System.out.println("Output \n" + result);
        } else if (roman == true & !map.containsValue(result)) {
            if (result <= 1) {
                throw new RuntimeException();
            }
            String [] ones = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
            String [] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC", "C"};

            int onesDigit = result % 10;
            int tensDigit = result / 10;
            System.out.println("Output \n"  + tens[tensDigit] + ones[onesDigit]);

        }

    }
}
