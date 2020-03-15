package Swing;

import javax.swing.*;

public class App {
    public static void main(String[] args) {

/**
 * creating an instance of an anonymous implementation of the Runnable interface
 */
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainFrame();

            }
        });

    }
}
