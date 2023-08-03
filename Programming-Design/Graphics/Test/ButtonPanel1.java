package Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ButtonPanel1 extends JPanel {
    public ButtonPanel1(){
        makeButton("Yellow", Color.YELLOW);
        makeButton("Blue", Color.BLUE);
        makeButton("Red", Color.RED);
    }

    public void makeButton(String name, final Color backgroundColor){
        JButton button = new JButton(name);
        add(button);
        final int[] i = {0};
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                i[0] += 1;
                setBackground(backgroundColor);
                button.setText(name + " " + i[0]);
            }
        });
    }
}
