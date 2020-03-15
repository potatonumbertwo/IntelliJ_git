package Unit5;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class SpellChecker {
    public static void main(String[] args) throws FileNotFoundException {
        Set<String> dictWords = new TreeSet<>(readFile());
        Set<String> words = getWordSet();
        TreeSet<String> dictWord = (TreeSet<String>) dictWords;
        for (String word : words) {
            TreeSet c = corrections(word, dictWord);
            if (c.isEmpty()) {
                System.out.println(word + ": (no suggestions)");
            } else
                System.out.println(word + ":" + c);
        }


    }

    public static Set<String> getWordSet() {

        String arr[] = {"html", "cpsc", "hashset", "treeset", "cvs",
                "isempty", "txt", "int","jfilechooser","pre","setdialogtitle","getinputfilenamefromuser"};
        Set<String> set = new TreeSet<>(Arrays.asList(arr));
        return set;
    }

    /**
     * read words.txt
     *
     * @throws FileNotFoundException
     */
    public static Set<String> readFile() throws FileNotFoundException {

        Set<String> words = new TreeSet<>();
        Scanner scanner = new Scanner(new File("/Users/crowfordcindy/Desktop/Programming1" +
                "/CS1102/src/payrollsystem/git_project/src/Unit5/words.txt"));
        scanner.useDelimiter("[^a-zA-Z]+");
        while (scanner.hasNext()) {
            String word = scanner.next();
            word = word.toLowerCase();
            words.add(word);
        }
        System.out.println(words.size()); // 72875
        return words;
    }

    /**
     * Lets the user select an input file using a standard file
     * selection dialog box.  If the user cancels the dialog
     * without selecting a file, the return value is null.
     */
    static File getInputFileNameFromUser() {

        JFileChooser fileDialog = new JFileChooser();
        fileDialog.setDialogTitle("Select File for Input");
        int option = fileDialog.showOpenDialog(null);
        if (option != JFileChooser.APPROVE_OPTION)
            return null;
        else
            return fileDialog.getSelectedFile();
    }

    static TreeSet corrections(String badWord, Set dictionary) {
        TreeSet<String> words = new TreeSet<String>();

        TreeSet<String> insert = insertCorrections(badWord, dictionary);
        TreeSet<String> delete = deleteCorrections(badWord, dictionary);
        TreeSet<String> swap = swapCorrections(badWord, dictionary);
        TreeSet<String> space = spaceCorrections(badWord, dictionary);
        TreeSet<String> change = changeCorrections(badWord, dictionary);
        words.addAll(insert);
        words.addAll(delete);
        words.addAll(swap);
        words.addAll(space);
        words.addAll(change);

        return words;

    }

    /**
     * Insert any letter at any point in the misspelled word.
     *
     * @param badWord
     * @param dictionary
     * @return
     */
    static TreeSet insertCorrections(String badWord, Set dictionary) {
        TreeSet<String> words = new TreeSet<String>();

        for (int i = 0; i <= badWord.length(); i++) {
            for (char ch = 'a'; ch <= 'z'; ch++) {
                String s = badWord.substring(0, i) + ch + badWord.substring(i, badWord.length());
                if (dictionary.contains(s)) {
                    words.add(s);
                }
            }
        }
        return words;

    }

    /**
     * Delete any one of the letters from the misspelled word
     *
     * @param badWord
     * @param dictionary
     * @return
     */
    static TreeSet<String> deleteCorrections(String badWord, Set<String> dictionary) {
        TreeSet<String> words = new TreeSet<>();

        for (int i = 0; i < badWord.length(); i++) {
            StringBuilder builder = new StringBuilder(badWord);
            builder.deleteCharAt(i);
            String stringWithDelete = builder.toString();

            if (dictionary.contains(stringWithDelete)) {
                words.add(stringWithDelete);
            }
        }

        return words;
    }

    /**
     * Swap any two neighboring characters in the misspelled word.
     *
     * @param badWord
     * @param dictionary
     * @return
     */
    static TreeSet<String> swapCorrections(String badWord, Set<String> dictionary) {
        TreeSet<String> words = new TreeSet<>();

        for (int i = 0; i < badWord.length() - 1; i++) {
            StringBuilder builder = new StringBuilder(badWord);
            char char1 = builder.charAt(i);
            char char2 = builder.charAt(i + 1);

            builder.setCharAt(i, char2);
            builder.setCharAt(i + 1, char1);

            String stringWithSwap = builder.toString();

            if (dictionary.contains(stringWithSwap)) {
                words.add(stringWithSwap);

            }
        }
        return words;
    }

    /**
     * Change any letter in the misspelled word to any other letter.
     *
     * @param badWord
     * @param dictionary
     * @return
     */
    static TreeSet<String> changeCorrections(String badWord, Set<String> dictionary) {
        TreeSet<String> words = new TreeSet<>();

        for (int i = 0; i < badWord.length(); i++) {
            StringBuilder builder = new StringBuilder(badWord);
            for (char ch = 'a'; ch <= 'z'; ch++) {
                builder.setCharAt(i, ch);
                String s = builder.toString();
                if (dictionary.contains(s)) {
                    words.add(s);
                }
            }
        }
        return words;
    }

    /**
     * Insert a space at any point in the misspelled word
     * (and check that both of the words that are produced are in the dictionary)
     *
     * @param badWord
     * @param dictionary
     * @return
     */
    static TreeSet<String> spaceCorrections(String badWord, Set<String> dictionary) {
        TreeSet<String> words = new TreeSet<>();
        for (int i = 0; i < badWord.length(); i++) {
            StringBuilder builder = new StringBuilder(badWord);
            builder.insert(i, ' ');
            String s = builder.toString();
            String[] splitString = s.split(" ");
            String s1 = splitString[0];
            String s2 = splitString[1];

            if (dictionary.contains(s1)) {
                words.add(s1);
            }
            if (dictionary.contains(s2)) {
                words.add(s2);
            }
        }
        return words;
    }
}
