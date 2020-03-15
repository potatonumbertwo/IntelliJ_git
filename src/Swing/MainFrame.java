package Swing;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    //    private JTextArea textArea;
//    private JButton button;
    private TextPanel textPanel;
    private Toolbar toolbar;


    public MainFrame() {

        super("I love my meow meow ");
        setSize(400, 500);

        setLayout(new BorderLayout());


//        textArea = new JTextArea();
        textPanel = new TextPanel();
        toolbar = new Toolbar();
// set textPanel in side of the toolbar
        toolbar.setTextPanel(textPanel);

        add(toolbar, BorderLayout.NORTH);
        add(textPanel, BorderLayout.CENTER);

//        button = new JButton("click me");
//        add(button, BorderLayout.SOUTH);


        // anonymous method
//        button.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
////                textPanel.appendText("I miss my meow meow\n");
//
//            }
//        });


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

}

