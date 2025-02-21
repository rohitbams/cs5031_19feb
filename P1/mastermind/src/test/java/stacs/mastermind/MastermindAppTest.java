package stacs.mastermind;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.Objects;

public class MastermindAppTest {
    
    private File testWordListFile;
    private String[] wordList;

    @BeforeEach
    public void loadTestWordList() {
        testWordListFile = new File(Objects.requireNonNull(this.getClass()
                        .getClassLoader()
                        .getResource("wordlist-test.txt"))
                .getFile());
    }

    @BeforeEach
    void setUp() {
        wordList = MastermindApp.getWords(testWordListFile);
    }

    @Test
    public void shouldLoadWordlist() {
        assertEquals(3, wordList.length);
    }

    @Test
    public void isGameOver_ShouldReturnTrue_WhenTriesExceedLimit() {
        MastermindApp.tries = 11;
        assertTrue(MastermindApp.isGameOver());
    }

    @Test
    public void isGameOver_ShouldReturnFalse_WhenTriesAreWithinLimit() {
        MastermindApp.tries = 5;
        assertFalse(MastermindApp.isGameOver());
    }

    @Test
    public void triesShouldIncrease() {
        int initialTries = MastermindApp.tries;
        MastermindApp.triesIncremented();
        assertEquals(initialTries + 1, MastermindApp.tries);
    }

    @Test
    public void matchAlphabet_ShouldReturnTrue_WhenLetterExistsInWord() {
        MastermindApp.questionWord = "apple";
        assertTrue(MastermindApp.matchAlphabet('p'));
    }

    @Test
    public void matchAlphabet_ShouldReturnFalse_WhenLetterDoesNotExistInWord() {
        MastermindApp.questionWord = "apple";
        assertFalse(MastermindApp.matchAlphabet('z'));
    }

    @Test
    public void isGuessedWordInWordlist_ShouldReturnTrue_ForValidWord() {
        MastermindApp.questionWord = "apple";
        assertTrue(MastermindApp.isGuessedWordInWordlist("apple"));
    }

    @Test
    public void isGuessedWordInWordlist_ShouldReturnFalse_ForInvalidWord() {
        MastermindApp.questionWord = "apple";
        assertFalse(MastermindApp.isGuessedWordInWordlist("xyzzy"));
    }

    @Test
    public void shouldShowGreyFeedbackForWrongLetters() {
        MastermindApp.questionWord = "apple";
        MastermindApp.checkWord("xxxxx");
        assertTrue(MastermindApp.grey > 0);
    }

    @Test
    public void shouldChooseRandomWord() {
        String randomWord = MastermindApp.chooseRandomWord(wordList);
        assertNotNull(randomWord);
        assertTrue(randomWord.length() > 0);
    }
}
