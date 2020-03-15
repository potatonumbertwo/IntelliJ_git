package Unit5;

import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import static org.junit.Assert.assertEquals;

public class SpellCheckerTest {
    @Test
    public void readFileTest() throws FileNotFoundException {
        Set<String> readFile = SpellChecker.readFile();

        assertEquals(72875, readFile.size());

    }

    /**
     * Insert any letter at any point in the misspelled word.
     *
     * @throws FileNotFoundException
     */
    @Test
    public void correctionsInsertTest() throws FileNotFoundException {
        Set<String> readFile = SpellChecker.readFile();
        String selectedWord = "zo";
        TreeSet<String> wordsTest = SpellChecker.insertCorrections(selectedWord, readFile);

        Set<String> expectedWords = new HashSet<>();

        expectedWords.add("zoo");
        expectedWords.add("zoe");
        assertEquals(expectedWords, wordsTest);
    }


    @Test
    public void deleteCorrectionsTest() throws FileNotFoundException {
        Set<String> readFile = SpellChecker.readFile();
        String selectedWord = "zoom";
        TreeSet<String> wordsTest = SpellChecker.deleteCorrections(selectedWord, readFile);

        Set<String> expectedWords = new HashSet<>();

        expectedWords.add("zoo");
        assertEquals(expectedWords, wordsTest);


    }

    @Test
    public void swapCorrectionsTest() throws FileNotFoundException {
        Set<String> readFile = SpellChecker.readFile();
        String selectedWord = "able";
        TreeSet<String> wordsTest = SpellChecker.swapCorrections(selectedWord, readFile);

        Set<String> expectedWords = new HashSet<>();

        expectedWords.add("bale");
        expectedWords.add("abel");

        assertEquals(expectedWords, wordsTest);


    }

    @Test
    public void changeCorrectionsTest() throws FileNotFoundException {
        Set<String> readFile = SpellChecker.readFile();
        String selectedWord = "able";
        TreeSet<String> wordsTest = SpellChecker.changeCorrections(selectedWord, readFile);

        Set<String> expectedWords = new HashSet<>();

        expectedWords.add("able");
        expectedWords.add("ably");
        expectedWords.add("axle");

        assertEquals(expectedWords, wordsTest);

    }


    @Test
    public void spaceCorrectionsTest() throws FileNotFoundException {
        Set<String> readFile = SpellChecker.readFile();
        String selectedWord = "isempty";
        TreeSet<String> wordsTest = SpellChecker.spaceCorrections(selectedWord, readFile);

        Set<String> expectedWords = new HashSet<>();

        expectedWords.add("is");
        expectedWords.add("empty");
        expectedWords.add("ty");

        assertEquals(expectedWords, wordsTest);

    }

    @Test
    public void correctionsTest() throws FileNotFoundException {
        Set<String> readFile = SpellChecker.readFile();
        String selectedWord = "int";
        TreeSet<String> wordsTest = SpellChecker.corrections(selectedWord, readFile);

        Set<String> expectedWords = new TreeSet<>();

        expectedWords.add("ant");
        expectedWords.add("dint");
        expectedWords.add("hint");
        expectedWords.add("in");
        expectedWords.add("ina");
        expectedWords.add("inc");
        expectedWords.add("ind");
        expectedWords.add("ink");
        expectedWords.add("inn");
        expectedWords.add("ins");
        expectedWords.add("inti");
        expectedWords.add("into");
        expectedWords.add("it");
        expectedWords.add("lint");
        expectedWords.add("mint");
        expectedWords.add("nit");
        expectedWords.add("pint");
        expectedWords.add("tint");

        Assert.assertEquals(expectedWords, wordsTest);


    }

}


