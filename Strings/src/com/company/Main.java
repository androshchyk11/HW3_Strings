package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*1. Существует текст и список слов. Для каждого слова из заданного
        списка найти, сколько раз оно встречается в тексте, и рассортировать
        слова по убыванию общего количества вхождений.*/
public class Main {

    static ArrayList<String> stringArray;
    static ListOfWords listOfWords = new ListOfWords();


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        addWords();

        int value = 0;
        output(value);
        String text = scanner.nextLine();
        text.toLowerCase();

        textToArray(text);
        count();
        printHowManyTimes();
        sortByTimes();
        printBySort();

    }

    private static void output(int i) {
        if (i == 0) {
            System.out.println("Input your text: ");
        }
    }

    private static void addWords() {
        try {
            Words wordArtem = new Words(0, "artem");
            listOfWords.words.add(wordArtem);
            Words wordFriend = new Words(0, "friend");
            listOfWords.words.add(wordFriend);
            Words wordGood = new Words(0, "good");
            listOfWords.words.add(wordGood);
            Words wordBoy = new Words(0, "boy");
            listOfWords.words.add(wordBoy);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void count() {
        System.out.println(stringArray.size());
        try {
            for (int i = 0; i < listOfWords.words.size(); i++) {
                for (int j = 0; j < stringArray.size(); j++) {
                    if (listOfWords.words.get(i).textOfWord.equals(stringArray.get(j))) {
                        listOfWords.words.get(i).quantityOfUse += 1;
                    }
                }
            }
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }

    private static void printBySort() {
        try {
            for (int i = 0; i < listOfWords.words.size(); i++) {
                System.out.println(listOfWords.words.get(i).textOfWord);
            }
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }

    private static void sortByTimes() {
        Words x;
        boolean isSorted = false;
        try {
            while (!isSorted) {
                isSorted = true;
                for (int i = 0; i < listOfWords.words.size() - 1; i++) {
                    if (listOfWords.words.get(i).quantityOfUse < listOfWords.words.get(i + 1).quantityOfUse) {
                        isSorted = false;
                        x = listOfWords.words.get(i);
                        listOfWords.words.set(i, listOfWords.words.get(i + 1));
                        listOfWords.words.set(i + 1, x);
                    }
                }
            }
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }

    private static void printHowManyTimes() {
        try {
            for (int i = 0; i < listOfWords.words.size(); i++) {
                System.out.println(listOfWords.words.get(i).textOfWord + " used " + listOfWords.words.get(i).quantityOfUse + " times");
            }
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }

    private static void textToArray(String text) {
        stringArray = new ArrayList<String>(Arrays.asList(text.split(" ")));
    }
}
