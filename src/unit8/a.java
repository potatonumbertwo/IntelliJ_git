/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unit8;

import javax.swing.*;
import java.io.File;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * @author user
 */
public class a {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        HashSet<String> misspelled;
        HashSet<String> dictionary;
        Scanner filein;
        Scanner in;
        File f;
        misspelled = new HashSet();
        f = getInputFileNameFromUser();
        try {
            filein = new Scanner(new File("/Users/crowfordcindy/Desktop/Programming1/CS1102/src/payrollsystem/git_project/src/unit8/words.txt"));
            dictionary = makeSet(filein);
            in = new Scanner(f);
            in.useDelimiter("[^a-zA-Z]+");
            while (in.hasNext()) {
                String word = in.next();
                if (!dictionary.contains(word)) {
                    misspelled.add(word);
                    System.out.println(word + ": " + corrections(word, dictionary));
                }
            }
            System.out.println("The file " + f + " contains " + (misspelled.size()) + " misspelled words");
            System.out.println("the misspelled words are " + misspelled);

        } catch (java.io.FileNotFoundException e) {
            System.out.println("No file(s) found." + e);
        }


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
    }//end of getInputFileNameFromUser

    /**
     * creates a HashSet from scanner input
     *
     * @param s
     * @return
     */
    static HashSet makeSet(Scanner s) {
        HashSet x;
        x = new HashSet();
        while (s.hasNext()) {
            String tk = s.next();
            x.add(tk);
        }
        return x;
    }//end of makeSet

    static TreeSet corrections(String badWord, HashSet dictionary) {
        TreeSet<String> t = new TreeSet();
        String w = badWord;
        for (char ch = 'a'; ch <= 'z'; ch++) {//changes the i-th char
            for (int i = 0; i < w.length(); i++) {
                String s = w.substring(0, i) + ch + w.substring(i + 1);
                if (dictionary.contains(s)) {
                    t.add(s);
                }
            }
        }
        for (char ch = 'a'; ch <= 'z'; ch++) {//adds new char
            for (int i = 0; i < w.length(); i++) {

                String s = w.substring(0, i) + ch + w.substring(i);
                if (dictionary.contains(s)) {
                    t.add(s);
                }
            }
        }
        for (int i = 0; i < w.length(); i++) {//adds space
            String s1 = w.substring(0, i);
            String s2 = w.substring(i);
            if (dictionary.contains(s1) && dictionary.contains(s2)) {
                t.add(s1 + ' ' + s2);
            }
        }
        for (int i = 0; i < w.length(); i++) {//removes char

            String s = w.substring(0, i) + w.substring(i + 1);
            if (dictionary.contains(s)) {
                t.add(s);
            }
        }
        for (int i = 0; i < w.length() - 1; i++) {//swaps chars
            String s = w.substring(0, i) + w.substring(i + 1, i + 2) + w.substring(i, i + 1) + w.substring(i + 2);
            if (dictionary.contains(s)) {
                t.add(s);
            }
        }
        if (t.isEmpty()) {
            t.add("(no suggestions)");
        }
        return t;
    }//end of corrections
}
