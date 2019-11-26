package com.company;

import java.util.Scanner;
/*4. В заданном тексте слова заданной длины заменить указанной
подстрокой, длина которой может не совпадать с длиной слова.*/
public class Main {

    private static StringBuilder firstText = new StringBuilder("This text is absolutely incredible? well, I think so");
    private static int length = 0;
    private static byte value = 0;
    private static Scanner scanner = new Scanner(System.in);
    private static String yourText;
    private static String[] textToArray;
    private static String textHelper = firstText.toString();

    public static void output(byte i) {
        if (i == 0) {
            System.out.println(firstText);
        } else if (i == 1) {
            System.out.print("Input length of a word to replace: ");
        } else if (i == 2) {
            System.out.println("Wrong type, input Integer value!!!");
        } else if (i == 3) {
            System.out.print("Input a word: ");
        }
    }

    private static void lengthSetter() {
        while (true) {
            try {
                value = 1;
                output(value);
                String stringLength = scanner.next();
                length = Integer.parseInt(stringLength);
                break;
            } catch (NumberFormatException nfe) {
                value = 2;
                output(value);
            }
        }
    }

    private static void subStringSetter() {
        value = 3;
        output(value);
        yourText = scanner.next();
    }

    private static void setTextToArray() {
        textToArray = textHelper.split(" ");
    }

    private static void changingWordsInArray() {
        try {
            for (int i = 0; i < textToArray.length; i++) {
                int j = 0;
                int k = 0;
                int q = 0;
                if (textToArray[i].length() == length) {
                    textToArray[i] = yourText;
                }
            }
        } catch (IndexOutOfBoundsException ioobe) {
            ioobe.printStackTrace();
        }
    }

    private static void changingWordsInText() {
        firstText.delete(0, firstText.length());

        try {
            for (int i = 0; i < textToArray.length; i++) {
                firstText.append(textToArray[i] + " ");
            }
        } catch (IndexOutOfBoundsException ioobe) {
            ioobe.printStackTrace();
        }
    }

    public static void main(String[] args) {
        value = 0;
        output(value);

        lengthSetter();

        subStringSetter();

        setTextToArray();

        changingWordsInArray();

        changingWordsInText();

        value = 0;
        output(value);
    }
}

