package com.company.View;
import javax.swing.*;


public class GuiView {

    public GuiView(){
        JFrame frame = new JFrame("Test Frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel();
        label.setText("Hello World!");

        frame.getContentPane().add(label);
        frame.setSize(720, 480);
        frame.setVisible(true);
    }
}
