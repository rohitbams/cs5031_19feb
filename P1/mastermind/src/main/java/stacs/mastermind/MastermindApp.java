package stacs.mastermind;

import java.io.*;
import java.util.Scanner;
import java.util.MissingFormatArgumentException;

public class MastermindApp {
    static File file = new File("/home/rb341/Documents/CS5031/Coursework/P1/P1/mastermind/src/main/resources/wordlist.txt");
    static String questionWord = chooseRandomWord(getWords(file)); // the word to be guessed
    static int tries = 1;

    static int green = 0;
    static int grey = 0;
    static int yellow = 0;

    static final String YELLOW_TEXT = "\u001B[33m";
    static final String GREEN_TEXT = "\u001B[32m";
    static final String RESET = "\u001B[0m";

    static String guessedWord = "";

    public static void main(String[] args) {
        System.out.println("Welcome to Mastermind!");
        Scanner scanner = new Scanner(System.in);

        while (tries <= 10) {
            try {
                System.out.println("questionWord: " + questionWord);
                System.out.println("Please enter a word: ");
                guessedWord = scanner.nextLine().toLowerCase();
                if (guessedWord.length() != 5) {
                    System.out.println("Try" + tries +" The guessed word should have 5 characters!");
                    triesIncremented();
                } else if (!isGuessedWordInWordlist(guessedWord)) {
                    System.out.println("Try" + tries + " Word does not exist in the word list!");
                    triesIncremented();
                } else if (guessedWord.equals(questionWord)) {
                    System.out.println("Congratulations! You guessed the correct word!");
                    scanner.close();
                    return;
                } else {
                    checkWord(guessedWord);
                }
            } catch (MissingFormatArgumentException e) {
                System.out.println(e.getMessage());
            }

            if (isGameOver()) {
                gameOver();
                scanner.close();
                return;
            }
        }
        gameOver();
        scanner.close();

    }

    private static void gameOver() {
        System.out.println("You exceeded the maximum number of tries!");
        System.out.println("You failed! The hidden word is " + questionWord + ".");

    }

    public static int triesIncremented() {
        return tries++;
    }

    // check if the character exist in the question word
    public static boolean matchAlphabet(char letter) {
        for (int i = 0; i < questionWord.length(); i++) {
            if (questionWord.charAt(i) == letter) {
                return true;
            }
        }
        return false;
    }

    public static void getGuessInput(String word) {

    }

    // check guess correctness
    public static void checkWord(String word) {
        System.out.printf("Try%d (%s):\n", tries, word);
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            if (matchAlphabet(letter)) {
                if (questionWord.charAt(i) == letter) {
//                    System.out.println("green: " + letter);
                    green++;
                } else if (questionWord.contains(String.valueOf(letter)) && questionWord.charAt(i) != letter) {
//                    System.out.println("yellow: " + letter);
                    yellow++;
                }
            } else {
                grey++;
            }
        }
        green();
        yellow();
        grey();
        triesIncremented();
        green = 0;
        yellow = 0;
        grey = 0;
    }

    static void green() {
        System.out.println(GREEN_TEXT + "You got " + green + " green letters." + RESET);
    }
    static void grey() {
        System.out.println("You got " + grey + " grey letters.");
    }
    public static void yellow() {
        System.out.println(YELLOW_TEXT + "You got " + yellow + " yellow letters." + RESET);
    }

    public static boolean isGameOver() {
        return tries > 10;
    }

    public static String chooseRandomWord(String[] words) {
        return words[(int) (Math.random() * words.length)];
    }

    // checks whether the guess is in the wordlist
    static boolean isGuessedWordInWordlist(String word) {
        for (String w : getWords(file)) {
            if (w.equals(word)) {
                return true;
            }
        }
        return false;
    }

    public static String[] getWords(File file) {
        // read the wordlist
        try {
            String[] newArray;
            BufferedReader br = new BufferedReader(new FileReader(file));
            newArray = br.lines().toArray(String[]::new);
            return newArray;
        } catch (FileNotFoundException e) {
            System.err.println("Word List file not found");
            throw new RuntimeException(e);
        }
    }
}
