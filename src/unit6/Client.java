package unit6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    private final int port = 6942;

    public static void main(String[] args) throws Exception {
        Client u = new Client();
        u.run();
    }

    public void run() throws Exception {
        InetAddress host = InetAddress.getLocalHost();
        Socket s = new Socket(host.getHostName(), port);
        PrintStream ps = new PrintStream(s.getOutputStream());
        ps.println("Hey bob ,are you there?");

        InputStreamReader isr = new InputStreamReader(s.getInputStream());
        BufferedReader br = new BufferedReader(isr);

        String message = br.readLine();
        System.out.println(message);
    }
}


//public class Client {
//
//    void clientConnection(String computerAddress, int serverPort) {
//        Socket socket;
//
//        try {
//            socket = new Socket(computerAddress, serverPort);
//            BufferedReader in = new BufferedReader(
//                    new InputStreamReader(socket.getInputStream()));
//            PrintWriter out =
//                    new PrintWriter(socket.getOutputStream(), true);
//        } catch (IOException e) {
//            System.out.println("Connectino Error: " + e);
//            return;
//        }
//
//        try {
//            socket.close();
//        } catch (IOException e) {
//        }
//
//    }
//}