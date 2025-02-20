package stacs.mastermind;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.MissingFormatArgumentException;

public class MastermindApp {
    static String questionWord = chooseRandomWord(getWords()); // the word to be guessed
    static String answer = ""; // user's guess
    static String line = "";
    static ArrayList<String> wordList = new ArrayList<>();
    static ArrayList<String> answers = new ArrayList<>(); // maybe implement an array of 10 answers per round
    static ArrayList<Character> alphabets = new ArrayList<Character>();
    static int tries = 0;
//
//    static int green = 0;
//    static int red = 0;
//    static int yellow = 0;

    static String guessedWord = "";
    static BufferedReader br;

    public static void main(String[] args) {
        File file = new File("/home/rb341/Documents/CS5031/Coursework/P1/P1/mastermind/src/main/resources/wordlist.txt");
        System.out.println("Welcome to Best value Wordle");
        System.out.println(wordList.size());
//        System.out.println(loadWordlist(file));
        int tries = 0; // number of tries per round
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.println(questionWord);
                System.out.println(getWords().length);
                System.out.println("Please enter a word: ");
                guessedWord = scanner.nextLine().toLowerCase();

                if (guessedWord.length() != 5) {
                    System.out.println("The guessed word should have 5 characters!");
                    tries++;
                } else if (!isGuessedWordInWordlist(guessedWord)) {
                    System.out.printf("Try %d (%s): Word does not exist in the dictionary!\n",
                            tries, guessedWord);
                } else if (guessedWord.equals(questionWord)) {
                    System.out.printf("Congratulations! You guessed right in %d shot!\n",
                            tries);
                    scanner.close();
                    return;
                } else {
                    checkWord(guessedWord);
                }
            } catch (MissingFormatArgumentException e) {
                System.out.println(e.getMessage());
            }

            if (isGameOver()) {
                System.out.println("You exceeded the maximum number of tries!");
                System.out.println("You failed! The key word is " + questionWord + ".");
                scanner.close();
                return;
//
//            if (guessedWord.equals(questionWord)) {
//                System.out.println("Correct answer!");
//                giveFeedback();
//                tries--;
//            }

            }
        }
    }

    private static void getAlphabet() {
        for (int i = 0; i < answer.length(); i++) {
            alphabets.add(answer.charAt(i));
        }
    }

    // check if the character exist in the question word
    private static boolean matchAlphabet(char letter) {
        for (int i = 0; i < questionWord.length(); i++) {
            if (questionWord.charAt(i) == letter) {
                return true;
            }
        }
        return false;
    }

    // check guess correctness
    private static void checkWord(String word) {
        System.out.printf("Try%d (%s):\n", tries, word);
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            if (matchAlphabet(letter)) {
                if (questionWord.charAt(i) == letter) {
                    System.out.printf("%d. letter exists and located in right position.\n", i + 1);
                } else {
                    System.out.printf("%d. letter exists but located in wrong position.\n", i + 1);
                }
            } else {
                System.out.printf("%d. letter does not exist.\n", i + 1);
            }
        }
        tries++;
        System.out.println();
    }

//    private static void giveFeedback() {
//        red();
//        green();
//        yellow();
//    }
//    private static void yellow() {
//        for (int i = 0; i < answer.length(); i++) {
//            if (alphabets.contains(questionWord.charAt(i))) {
//                yellow++;
//                System.out.println("You have " + answers.size() + " guesses!");
//            }
//        }
//    }
//
//    private static void green() {
//        for (int i = 0; i < answer.length(); i++) {
//            if (alphabets.contains(questionWord.charAt(i))) {
//                green++;
//            }
//        }
//    }
//
//    private static void red() {
//
//    }

    static boolean guessCorrect(String answer) {
        if (answers.equals(answer)) {
            return true;
        }
        return false;
    }

    static boolean isGameOver() {
        return tries > 10;
    }

    static String chooseRandomWord(String[] words) {
        return words[(int) (Math.random() * words.length)];
    }

    // checks whether the guess is in the wordlist
    static boolean isGuessedWordInWordlist(String word) {
        for (String w : getWords()) {
            if (w.equals(word)) {
                return true;
            }
        }
        return false;
    }

    protected static ArrayList<String> loadWordlist(File file) {
        try {
            br = new BufferedReader(new FileReader(file));
            Random randomizer = new Random();
//                return String randomWord = wordlist.get(randomizer.nextInt(wordlist.size()));
//                return (ArrayList<String>) br.lines().filter(s -> !s.isEmpty()).collect(Collectors.toList());
            while ((line = br.readLine()) != null) {
                wordList.add(line);
            }
            return wordList;
        } catch (FileNotFoundException e) {
            System.err.println("Word List file not found");
            throw new RuntimeException(e);
        } catch (IOException e) {
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
