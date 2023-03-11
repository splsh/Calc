package com.example.calc;

import java.util.HashMap;
import java.util.Map;

public class Main {
//

    public static String calc(String input) {
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
        String[] temp = input.split(" ");
        if (temp.length > 3) {
            throw new RuntimeException();
        }
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
                    return entry.getKey();
                }
            }
        } else if (!roman) {
            return String.valueOf(result);
        } else if (roman & !map.containsValue(result)) {
            if (result < 1) {
                throw new RuntimeException();
            }
            String[] ones = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
            String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC", "C"};

            int onesDigit = result % 10;
            int tensDigit = result / 10;
            return tens[tensDigit] + ones[onesDigit];

        }
        return "";
    }

    public static void main(String[] args) {
        String test = "1 + 6";
        String test1 = "-7 + 9";
        String test2 = "5 * 8";
        String test3 = "V + III";
        String test4 = "5 + X";
        String test5 = "X * X";
        String test6 = "X / III";
        String test7 = "V - X";
        String test8 = "11 + 2";
        String test9 = "5 + 3 + 7";
        String test10 = "V + II + X";
        String test11 = "9 - 9";
        String test12 = "9 - 10";
        String test13 = "I * I";
        System.out.println(calc(test13));

    }
}
