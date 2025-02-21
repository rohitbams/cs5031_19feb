package stacs.mastermind;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.File;
import java.util.Objects;


public class MastermindAppTest {

    // clean up the code by calling MastermindApp directly instead of mApp
//    private final MastermindApp mApp = new MastermindApp();
//    private String guess = "";
    private File testWordListFile;
    private String[] wordList;



    MastermindApp mApp;

    @BeforeEach
    public void loadTestWordList () {
        testWordListFile = new File(Objects.requireNonNull(this
                        .getClass()
                        .getClassLoader()
                        .getResource("wordlist-test.txt"))
                                    .getFile());
    }
    @BeforeEach
    void setUp() {
        mApp = new MastermindApp();
        wordList = mApp.getWords(testWordListFile);
    }

    @Test
    public void shouldLoadWordlist() {
        assertEquals(3, wordList.length);
    }


    // tries should remain consistent across all conditional statements
    // tries should not reset after non-existing word
    // tries should not reset after longer than a five-letter word



    @Test
    public void isGameOver() {
//        mApp.tries = 0;
        assertTrue(MastermindApp.isGameOver());
    }

    @Test
    public void guessCorrect() {
//        assertTrue(true, mApp.guessCorrect(guess));
    }


    @Test
    public void guessWrong() {
//        assertFalse(false, mApp.guessCorrect());
    }

    @Test
    public void shouldTakeUserInput() {
        int tries = 4;
        String word = "longword";
//        assertEquals("longword", mApp.getGuessedWord());
    }

    @Test
    public void shouldCheckIfLetterExistsInWord() {
//        assertTrue(true, mApp.matchAlphabet('a'));
    }

    @Test
    public void wordUnder5Letters() {}

    @Test
    public void getRandomWord() {
//        assertEquals(1, mApp.chooseRandomWord());

    }

    @Test
    public void shouldShowGreyFeedbackForWrongLetters() {
        assertTrue(MastermindApp.grey > 0);
    }

    @Test
    public void triesShouldIncrease() {
        int tries = 4;
        assertEquals(3, mApp.triesIncremented());
    }

}
