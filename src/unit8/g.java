package unit8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class g {
    static void readTextFromURL(String urlString) throws IOException {
            /* Open a connection to the URL, and get an input stream
              for reading data from the URL. */
        URL url = new URL(urlString);
        URLConnection connection = url.openConnection();
        InputStream urlData = connection.getInputStream();
            /* Check that the content is some type of text.  Note:
               connection.getContentType() method should be called
               after getInputStream(). */
        String contentType = connection.getContentType();
        System.out.println("Stream opened with content type: " + contentType);
        System.out.println();
        if (contentType == null || contentType.startsWith("text") == false)
            throw new IOException("URL does not seem to refer to a text file.");
        System.out.println("Fetching context from " + urlString + " ...");
        System.out.println();
            /* Copy lines of text from the input stream to the screen, until
              end-of-file is encountered  (or an error occurs). */
        BufferedReader in;  // For reading from the connection’s input stream.
        in = new BufferedReader(new InputStreamReader(urlData));
        while (true) {
            String line = in.readLine();
            if (line == null)
                break;
            System.out.println(line);
        }
        in.close();
    } // end readTextFromURL()

}
