package Main2;

import javax.swing.*;
import java.awt.event.*;

public class Menu extends JMenuBar {
    public Menu() {
        // Создать меню File
        JMenu jmFile = new JMenu("File"); //Файл
        jmFile.setMnemonic(KeyEvent.VK_F); // Задать мнемонику

        JMenuItem jmiNew = new JMenuItem("New"); // Новая игра
        jmiNew.setMnemonic(KeyEvent.VK_N); // Задать мнемонику
        jmiNew.setAccelerator(KeyStroke.getKeyStroke("ctrl N")); // Задать акселератор
        jmiNew.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                // Обновить массив dice
                Dice.dice = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 0};
                Dice.indexOfNull = 15;
                // Заново перетасовать (метод shuffle)
                Dice.shuffle();
                // Обновить кнопки (метод update)
                Panel.update();
            }
        });
        jmFile.add(jmiNew);

        JMenuItem jmiExit = new JMenuItem("Exit"); // Выход
        jmiExit.setAccelerator(KeyStroke.getKeyStroke("ctrl E")); // Задать акселератор
        jmiExit.setMnemonic(KeyEvent.VK_E); // Задать мнемонику
        jmiExit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        jmFile.add(jmiExit);

        add(jmFile);

        // Создать меню Help
        JMenu jmHelp = new JMenu("Help"); // Справка
        jmHelp.setMnemonic(KeyEvent.VK_H); // Задать мнемонику

        JMenuItem jmiAbout = new JMenuItem("About"); // О программе
        jmiAbout.setMnemonic(KeyEvent.VK_A); // Задать мнемонику
        jmiAbout.setAccelerator(KeyStroke.getKeyStroke("ctrl A")); // Задать акселератор
        jmiAbout.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                // Открыть диалоговое окно с текстом
                JOptionPane.showMessageDialog(null, "Игнатова Галина, P3165, 2023", "About", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        jmHelp.add(jmiAbout);

        add(jmHelp);
    }
}
