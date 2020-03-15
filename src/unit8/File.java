package unit8;

/**
 *
 */

import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.HashSet; // Import the HashSet for our dictionary

/**
 * @author iykyvic
 *
 */
public class File {

    /**
     * @param String path file path
     * @return HashSet<String> dictionary
     */
    public static HashSet<String> read(String path) {
        HashSet<String> dictionary = new HashSet<String>();

        try {
            java.io.File file = new java.io.File(path);
            Scanner reader = new Scanner(file);

            reader.useDelimiter("[^a-zA-Z]+");

            while (reader.hasNextLine())
                dictionary.add(reader.nextLine().toLowerCase().trim());

            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return dictionary;
    }
}
