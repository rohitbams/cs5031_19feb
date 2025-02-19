package stacs.mastermind;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MastermindApp {
    static String questionWord = ""; // the word to be guessed
    static String answer = ""; // user's guess
    static ArrayList<String> answers = new ArrayList<>(); // maybe implement an array of 10 answers per round
    static int tries = 0;

//    public String guessedWord;

    public static void main(String[] args) {
        File file = new File("/home/rb341/Documents/CS5031/Coursework/P1/P1/mastermind/src/main/resources/wordlist.txt");
        System.out.println("Welcome to Best value Wordle");
//        System.out.println(loadWordlist(file));
        int tries = 0; // number of tries per round
        Scanner scanner = new Scanner(System.in);

        while (tries < 10) {
            String guessedWord;
            System.out.println("Please enter a word: ");
            guessedWord = scanner.nextLine().toLowerCase();
            tries++;
            if (guessedWord.length() != 5) {
                System.out.println("The guessed word should have 5 characters!");
            }


        }
    }

    static boolean isGameOver() {
        return tries > 10;
    }

    static String chooseRandomWord(String[] words) {
        return words[(int) (Math.random() * words.length)];
    }

    static boolean isGuessedWordInWordlist(String word) {
        for (String w : getWords()) {
            if (w.equals(word)) {
                return true;
            }
        }
        return false;
    }

//    static

    // Unimplemented skeleton
    // You may refactor this method
    protected static ArrayList<String> loadWordlist(File file) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("../../../resources/wordlist.txt"));
            return (ArrayList<String>) br.lines().filter(s -> !s.isEmpty()).collect(Collectors.toList());
        } catch (FileNotFoundException e) {
            System.err.println("Word List file not found");
            throw new RuntimeException(e);
        }
    }

    static String[] getWords() {
        // read the wordlist
        try {
            String[] newArray;
            BufferedReader br = new BufferedReader(new FileReader("/home/rb341/Documents/CS5031/Coursework/P1/P1/mastermind/src/main/resources/wordlist.txt"));
            newArray = br.lines().toArray(String[]::new);
            return newArray;
        } catch (FileNotFoundException e) {
            System.err.println("Word List file not found");
            throw new RuntimeException(e);
        }
    }


}
