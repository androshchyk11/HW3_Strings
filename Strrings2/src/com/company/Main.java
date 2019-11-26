package com.company;

/*2. Отсортировать слова в тексте по убыванию количества вхождений
        заданного символа, а в случае равенства – по алфавиту.*/

import java.util.*;

public class Main {

    private static String inputText;
    private static String inputSymbolString;
    private static char inputSymbol;
    private static Scanner scanner = new Scanner(System.in);
    private static StringBuilder finalString = new StringBuilder();
    private static ArrayList<Integer> counter = new ArrayList<>();
    private static String[] textArray;

    private static void output(int i) {
        if (i == 0) {
            System.out.print("Input your text: ");
        } else if (i == 1) {
            System.out.print("Input a letter: ");
        } else if (i == 2) {
            System.out.println(finalString);
        }
    }

    private static void textSetter() {
        inputText = scanner.nextLine();
        inputText = inputText.toLowerCase();
        System.out.println(inputText);
    }

    private static void letterSetter() {
        inputSymbolString = scanner.next();
        inputSymbol = inputSymbolString.charAt(0);
    }

    private static void arraySetter() {
        textArray = inputText.split(" ");
    }

    private static void counterOfSymbolInWords() {
        try {
            for (int i = 0; i < textArray.length; i++) {
                String s = textArray[i];
                int k = 0;
                for (int j = 0; j < s.length(); j++) {
                    if (s.charAt(j) == inputSymbol) {
                        k += 1;
                    }
                }
                counter.add(k);
            }
        } catch (IndexOutOfBoundsException ioobe) {
            ioobe.printStackTrace();
        }
    }

    private static void sortingByCount() {
        int x;
        String helper;
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < counter.size() - 1; i++) {
                if (counter.get(i) < counter.get(i + 1)) {
                    isSorted = false;
                    x = counter.get(i);
                    helper = textArray[i];
                    counter.set(i, counter.get(i + 1));
                    counter.set(i + 1, x);
                    textArray[i] = textArray[i + 1];
                    textArray[i + 1] = helper;
                }
            }
        }

    }

    private static void sortingByAlphabet() {
        Arrays.sort(textArray);
    }

    private static void settingTheFinalText() {
        try {
            for (int i = 0; i < textArray.length; i++) {
                finalString.append(textArray[i] + " ");
            }
        } catch (IndexOutOfBoundsException ioobe) {
            ioobe.printStackTrace();
        }
    }

    public static void main(String[] args) {
        int value = 0;
        output(value);
        textSetter();

        value += 1;
        output(value);
        letterSetter();

        arraySetter();

        counterOfSymbolInWords();

        sortingByCount();

        sortingByAlphabet();

        settingTheFinalText();

        value += 1;
        output(value);
    }
}
