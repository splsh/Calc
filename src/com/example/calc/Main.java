package com.example.calc;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
// не очень хорошо изначально начал, но удалять не стал, потому что так видно как шел поток сознания.

    public static void main(String[] args) {
        boolean roman = false;
        Map<String, Integer> map = new HashMap<>();
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
        }
        int firstNumber = Integer.parseInt(temp[0]);
        int secondNumber = Integer.parseInt(temp[2]);
        if (firstNumber > 10 || firstNumber < 1 || secondNumber > 10 || secondNumber < 1) {
            throw new RuntimeException();
        }
        char operation = temp[1].charAt(0);
        int result = switch (operation) {
            case '+' -> firstNumber + secondNumber;
            case '-' -> firstNumber - secondNumber;
            case '*' -> firstNumber * secondNumber;
            case '/' -> firstNumber / secondNumber;
            default -> throw new RuntimeException();
        };
        if (roman & map.containsValue(result)) {
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (entry.getValue().equals(result)) {
                    System.out.println("Output \n" + entry.getKey());
                }
            }
        } else if (!roman) {
            System.out.println("Output \n" + result);
        } else if (roman & !map.containsValue(result)) {
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
