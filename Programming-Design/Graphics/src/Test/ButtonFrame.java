package Test;

import javax.swing.*;

public class ButtonFrame extends JFrame {
    public ButtonFrame(){
        setTitle("Test.ButtonTest");
        setSize(300, 200);
        ButtonPanel1 panel = new ButtonPanel1();
        add(panel);
    }
}
