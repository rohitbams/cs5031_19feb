package stacs.mastermind;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.io.File;


public class MastermindAppTest {

    // clean up the code by calling MastermindApp directly instead of mApp
    private final MastermindApp mApp = new MastermindApp();
    private File testWordListFile;
    private ArrayList<String> wordlist;
    private String guess = "";


    @BeforeEach
    public void loadTestWordList () {
        testWordListFile = new File(this
                                    .getClass()
                                    .getClassLoader()
                                    .getResource("wordlist-test.txt")
                                    .getFile());
    }
    
    @Test
    public void shouldLoadWordlist() {
        wordlist = MastermindApp.loadWordlist(testWordListFile);
        // test wordlist only contains 3 words, so wordlist should have the size of 3
        assertEquals(3, wordlist.size());
    }

    @Test
    public void isGameOver() {
//        mApp.tries = 0;
        assertTrue(mApp.isGameOver());
    }

    @Test
    public void guessCorrect() {
        guess = "cache";
//        assertTrue(true, mApp.guessCorrect(guess));
    }


    @Test
    public void guessWrong() {
//        assertFalse(false, mApp.guessCorrect());
    }

    @Test
    public void wordOver5Letters() {
//        assertEquals(int 5, mApp.chooseRandomWord(wordlist).chars());
    }

    @Test
    public void wordUnder5Letters() {}

    @Test
    public void getRandomWord() {
        //assertEquals();

    }
}
