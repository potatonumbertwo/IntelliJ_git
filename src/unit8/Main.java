package unit8;

import textio.TextIO;

import java.util.*;

/**
 * @author iykyvic
 *
 */
public class Main {

    private static HashMap<String, TreeSet<String>> suggestions = new HashMap<String, TreeSet<String>>();
    private static ArrayList<String> badWords = new ArrayList<String>(
            Arrays.asList(
                    "html",
                    "cpsc",
                    "hashset",
                    "treeset",
                    "cvs",
                    "isempty",
                    "href",
                    "txt",
                    "filein",
                    "pre",
                    "hasnext",
                    "wordlist",
                    "getinputfilenamefromuser",
                    "jfilechooser",
                    "filedialog",
                    "setdialogtitle",
                    "int"
            )
    );

    /**
     * Main program
     *
     * @param args
     */
    public static void main(String[] args) {
        HashSet<String> dictionary =  File.read(getUserFileInput());
        validateDictionary(dictionary);
        mapCorrections(badWords, dictionary);
        displayCorrections(suggestions);
    }

    /**
     * validate dictionary
     *
     * @param HashSet<String> dictionary
     *
     * @return void
     */
    private static void validateDictionary(HashSet<String> dictionary) {
        ArrayList<String> words = new ArrayList<String>(Arrays.asList("Aberdeen", "Canberra", "Canaveral", "mozzarella"));
        System.out.println(String.format("\nDictonary contains %d words", dictionary.size()));
        System.out.println("Dictonary contains the following words:");
        words.forEach((String word) -> System.out.println(String.format("  %s: %b", word, dictionary.contains(word.toLowerCase()))));
    }

    private static void displayCorrections(HashMap<String, TreeSet<String>> suggestions) {
        System.out.println("\nCorrections contains:");
        suggestions.forEach((String key, TreeSet<String> suggestion) -> {
            System.out.println(String.format("  %s: %s", key, suggestion.isEmpty() ? "(no suggestions)" : suggestion.toString()));
        });
    }

    private static void mapCorrections(ArrayList<String> badWords, HashSet<String> dictionary) {
        badWords.forEach((String word) -> suggestions.put(word, corrections(word, dictionary)));
    }

    /**
     * get user file path input
     *
     * @return String
     */
    private static String getUserFileInput() {
        System.out.print("Enter File Path(e.g \"words.txt\"): ");
        return TextIO.getln().strip();
    }

    private static TreeSet<String> corrections(String badWord, HashSet<String> dictionary) {
        TreeSet<String> matches = new TreeSet<String>();
        if (badWord.length() < 2 || dictionary.contains(badWord)) return matches;
        matches.addAll(spaceCheck(badWord, dictionary));
        matches.addAll(deleteCheck(badWord, dictionary));
        matches.addAll(letterSwap(badWord, dictionary));
        matches.addAll(letterInsert(badWord, dictionary));
        matches.addAll(consecutiveSwap(badWord, dictionary));
        return matches;
    }

    /**
     * spaceCheck
     * get corrections by inserting a space at any point in the misspelled word
     * (and check that both of the words that are produced are in the dictionary)
     *
     * @param badWord
     * @param dictionary
     * @return TreeSet<String>
     */
    private static TreeSet<String> spaceCheck(String badWord, HashSet<String> dictionary) {
        TreeSet<String> matches = new TreeSet<String>();
        int index = 2;
        while (index < badWord.length() - 1) {
            String needle = String.format("%s %s", badWord.substring(0, index), badWord.substring(index));
            ArrayList<String> needles = new ArrayList<String>(Arrays.asList(needle.split(" ")));
            needles.forEach((String word) -> { if (dictionary.contains(word)) matches.add(word); });
            index++;
        }
        return matches;
    }

    /**
     * deleteCheck
     * get Corrections by deleting any one of the letters from the misspelled word.
     *
     * @param badWord
     * @param dictionary
     * @return TreeSet<String>
     */
    private static TreeSet<String> deleteCheck(String badWord, HashSet<String> dictionary) {
        TreeSet<String> matches = new TreeSet<String>();
        int index = 0;
        while (index < badWord.length()) {
            String needle = new StringBuilder(badWord).deleteCharAt(index).toString();
            if (dictionary.contains(needle)) matches.add(needle);
            index++;
        }
        return matches;
    }

    /**
     * letterSwap
     * get corrections by changing any letter in the misspelled word to any other letter.
     *
     * @param badWord
     * @param dictionary
     * @return TreeSet<String>
     */
    private static TreeSet<String> letterSwap(String badWord, HashSet<String> dictionary) {
        TreeSet<String> matches = new TreeSet<String>();
        String alphabets = "abcdefghijklmnopqrstuvwxyz";
        int index = 0;
        while (index < alphabets.length()) {
            int pointer = 0;
            String letter = Character.toString(alphabets.charAt(index));
            while (pointer < badWord.length()) {
                String needle = new StringBuilder(badWord).replace(pointer, pointer + 1, letter).toString();
                if (dictionary.contains(needle)) matches.add(needle);
                pointer++;
            }
            index++;
        }
        return matches;
    }

    /**
     * letterInsert
     * get corrections by inserting any letter at any point in the misspelled word.
     *
     * @param badWord
     * @param dictionary
     * @return TreeSet<String>
     */
    private static TreeSet<String> letterInsert(String badWord, HashSet<String> dictionary) {
        TreeSet<String> matches = new TreeSet<String>();
        String alphabets = "abcdefghijklmnopqrstuvwxyz";
        int index = 0;
        while (index < alphabets.length()) {
            int pointer = 0;
            String letter = Character.toString(alphabets.charAt(index));
            while (pointer < badWord.length()) {
                String needle = String.format("%s%s%s", badWord.substring(0, pointer), letter, badWord.substring(pointer));
                if (dictionary.contains(needle)) matches.add(needle);
                pointer++;
            }
            index++;
        }
        return matches;
    }

    /**
     * consecutiveSwap
     * get corrections by swapping any two neighboring characters in the misspelled word.
     *
     * @param badWord
     * @param dictionary
     * @return TreeSet<String>
     */
    private static TreeSet<String> consecutiveSwap(String badWord, HashSet<String> dictionary) {
        TreeSet<String> matches = new TreeSet<String>();
        int index = 0;
        while(index < badWord.length() - 1) {
            String currentChar = Character.toString(badWord.charAt(index));
            String nextChar = Character.toString(badWord.charAt(index + 1));
            String needle = String.format(
                    "%s%s%s%s",
                    badWord.substring(0, index),
                    nextChar,
                    currentChar,
                    badWord.substring(index + 2)
            );
            if (dictionary.contains(needle)) matches.add(needle);
            index += 2;
        }
        return matches;
    }
}
