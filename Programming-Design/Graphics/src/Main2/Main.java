package Main2;

import javax.swing.*;

public class Main {
    public static void main(String[] args){
        Dice.shuffle();
        Frame myFrame = new Frame();
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setVisible(true);
    }
}
