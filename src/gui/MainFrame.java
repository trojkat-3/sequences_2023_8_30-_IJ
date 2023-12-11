package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private JPanel mainPanel;
    private JPanel topPanel;
    private JPanel buttonPanel;
    private JPanel centralPanel;
    private JButton buttonQuit;
    private JButton buttonReset;
    private JButton buttonCredits;

    public MainFrame(){
        super();
        this.setContentPane(mainPanel);
        buttonQuit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                actionQuit();
            }
        });
    }

     private void actionQuit(){
        this.dispose();
    }
}
