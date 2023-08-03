package Main2;

import javax.swing.*;
import java.awt.event.*;

// Класс фрейма
public class Frame extends JFrame {
    public Frame() {
        setTitle("Пятнашки"); // Задать имя "Пятнашки"
        setSize(300, 300); // Задать размеры фрейма (setSize)
        setLocationRelativeTo(null); // Центрировать фрейм (setLocationRelativeTo(null))
        setResizable(false); // Запретить менять размер фрейма (setResizable(false))

        // Создать панель и добавить в фрейм
        Panel panel = new Panel(this);
        add(panel);

        // Создать меню и добавить в фрейм
        Menu menu = new Menu();
        setJMenuBar(menu);
    }
}
