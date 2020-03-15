package unit8;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author guillermo
 */


import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;


public class i {

    public static void main(String[] args) {

        Scanner scanner;                                   // Declare a new Scanner
        HashSet<String> stringHashSet = new HashSet<String>();
        Scanner userInputFileScanner;

        try {
            scanner = new Scanner(new File("/Users/crowfordcindy/Desktop/Programming1/CS1102/src/payrollsystem/git_project/src/unit8/words.txt"));   // Try to open such file

            while (scanner.hasNext()) {
                String word = scanner.next();
                stringHashSet.add(word.toLowerCase());
            }

            userInputFileScanner = new Scanner(new File("/Users/crowfordcindy/Desktop/Programming1/CS1102/src/payrollsystem/git_project/src/unit8/badwords.txt"));

            // Skip over any characters without letters.

            userInputFileScanner.useDelimiter("[^a-zA-Z]+");

            HashSet<String> incorrectWords = new HashSet<String>();
            while (userInputFileScanner.hasNext()) {
                String userSelectedWord = userInputFileScanner.next();
                userSelectedWord = userSelectedWord.toLowerCase();
                if (!stringHashSet.contains(userSelectedWord) &&
                        !incorrectWords.contains(userSelectedWord)) {

                    incorrectWords.add(userSelectedWord);
                    TreeSet<String> correctWords = new TreeSet<String>();
                    correctWords = corrections(userSelectedWord, stringHashSet);

                    System.out.print(userSelectedWord + ": ");

                    if (correctWords.isEmpty())
                        System.out.println("(There are no suggested options)");
                    else {
                        int count = 0;
                        for (String goodWord: correctWords) {
                            System.out.print(goodWord);
                            if (count < correctWords.size() - 1)
                                System.out.print(", ");
                            else
                                System.out.print("\n");
                            count++;
                        }
                    }
                }
            }
        }
        catch (FileNotFoundException e) {
            System.exit(0);
        }

    } // end main()
    static TreeSet corrections(String wrongWord, HashSet dictionary) {

        TreeSet<String> optionalWords =  new TreeSet<String>();
        String subString1, subString2, possible;

        for (int i = 0; i < wrongWord.length(); i++) {

            // Remove i character i.
            subString1 = wrongWord.substring(0, i);
            subString2 = wrongWord.substring(i + 1);

            // Delete any one of the letters in the incorrect word.
            possible = subString1 + subString2;
            if (dictionary.contains(possible))
                optionalWords.add(possible);

            // Change letter into any other letter

            for (char ch = 'a'; ch <= 'z'; ch++) {
                possible = subString1 + ch + subString2;
                if (dictionary.contains(possible))
                    optionalWords.add(possible);
            }

            // Slice the word into 2 words substrings
            subString1 = wrongWord.substring(0, i);
            subString2 = wrongWord.substring(i);

            // Insert any letter at any point in the misspelled word.
            for (char ch = 'a'; ch <= 'z'; ch++) {
                possible = subString1 + ch + subString2;
                if (dictionary.contains(possible))
                    optionalWords.add(possible);
            }

            // Insert a blank space in the misspelled word
            char ch = ' ';
            possible = subString1 + ch + subString2;
            if (dictionary.contains(subString1) && dictionary.contains(subString2))
                optionalWords.add(possible);

        }

        // Swap two characters in a mispelled word
        for (int i = 1; i < wrongWord.length(); i++) {

            subString1 = wrongWord.substring(0, i - 1);
            char ch1 = wrongWord.charAt(i - 1);
            char ch2 = wrongWord.charAt(i);
            subString2 = wrongWord.substring(i + 1);
            possible = subString1 + ch2 + ch1 + subString2;
            if (dictionary.contains(possible))
                optionalWords.add(possible);

        }
        return optionalWords;
    }

    /**
     * The user selects a file for the input

     * @return If ther exists then a file is selected by the user.
     */
    static File getInputFileNameFromUser() {

        JFileChooser fileSelectDialog = new JFileChooser();
        fileSelectDialog.setDialogTitle("Select the desired input file");

        int option = fileSelectDialog.showOpenDialog(null);

        if (option != JFileChooser.APPROVE_OPTION)
            return null;
        else
            return fileSelectDialog.getSelectedFile();

    }



}
