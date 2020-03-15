package unit6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private final int port = 6942;

    public static void main(String[] args) {
        Server c = new Server();
        try {
            c.runServer();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void runServer() throws Exception {
        ServerSocket serverSocket = new ServerSocket(port);

        // Listen
        Socket s = serverSocket.accept();

        InputStreamReader isr = new InputStreamReader(s.getInputStream());
        BufferedReader br = new BufferedReader(isr);

        String message = br.readLine();
        System.out.println(message);

        if (message != null) {
            PrintStream ps = new PrintStream(s.getOutputStream());
            ps.println("Hey I am here");
        }

    }
}


//import java.io.IOException;
//import java.net.ServerSocket;
//import java.net.Socket;
//
//public class Server {
//    public static final int listeningPort = 8080;
//    static ServerSocket server;
//    Socket connection;
//    public static void main(String[] args) {
//        try {
//            server = new ServerSocket(listeningPort);
//            System.out.println("ServerSocket is listening on port " + listeningPort);
//            while (true) {
//                Socket connection = server.accept();
//                serverMethod(connection);// Call the method that deals with the reason for the connection
//            }
//        }
//        catch (IOException e) {
//            System.out.println("Server disconected: " + e);
//        }
//    }
//    private static void serverMethod(Socket connection) {
//        // TODO Auto-generated method stub
//    }
//
//}