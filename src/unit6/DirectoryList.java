package unit6;

import java.io.File;
import java.util.Scanner;

/**
 * This program lists the files in a directory specified by
 * the user.  The user is asked to type in a directory name.
 * If the name entered by the user is not a directory, a
 * message is printed and the program ends.
 */
public class DirectoryList {
    /**
     * check the files if it is a directory
     *
     * @param directory
     */
    public static void fileList(File directory) {


        System.out.println("directory \"" + directory.getName() + "\"");
        String[] files = directory.list();
        assert files != null;
        for (String s : files) {
            File file = new File(directory, s);
            if (file.isDirectory()) {
                fileList(file);
            } else {
                System.out.println(s);
            }
        }

    }

    public static void main(String[] args) {

        String directoryName;  // Directory name entered by the user.
        File directory;        // File object referring to the directory.
//        String[] files;        // Array of file names in the directory.
        Scanner scanner;       // For reading a line of input from the user.

        scanner = new Scanner(System.in);  // scanner reads from standard input.

        System.out.print("Enter a directory name: ");
        directoryName = scanner.nextLine().trim();
        directory = new File(directoryName);

        if (!directory.isDirectory()) {
            if (!directory.exists())
                System.out.println("There is no such directory!");
            else
                System.out.println("That file is not a directory.");
        } else {
//            files = directory.list();
//            System.out.println("Files in directory \"" + directory + "\":");
//            for (int i = 0; i < files.length; i++)
//                System.out.println("   " + files[i]);
            fileList(directory);

        }

    } // end main()

} // end class DirectoryList
