package Main2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// Класс панели с кнопками
public class Panel extends JPanel{
    Font f = new Font("Monospaced", Font.PLAIN, 18);
    private static final JButton[] buttons = new JButton[16]; // массив кнопок для отображения чисел

    public Panel(Frame frame){
        // Задать диспетчер компоновки GridLayout
        setLayout(new GridLayout(4, 4));
        init();

        // Добавить в панель обработку событий клавиатуры (addKeyListener)
        /*
            int index = Dice.getIndexOfNull();
            Если пользователь нажал кнопку "влево"
                Проверить находится ли нулевой элемент в первых трех столбцах (indexOfNull % 4 != 3)
                    Поменять местами нулевой элемент и элемент справа от него (метод Dice.swap(index, index + 1))
                    Dice.setIndexOfNull(index + 1)
            Если пользователь нажал кнопку "вверх"
                Проверить находится ли нулевой элемент в первых трех строчках (indexOfNull < 12)
                    Поменять местами нулевой элемент и элемент снизу от него (метод Dice.swap(index, index + 4))
                    Dice.setIndexOfNull(index + 4)
            Если пользователь нажал кнопку "вправо"
                Проверить находится ли нулевой элемент в последних трех столбцах (indexOfNull % 4 != 0)
                    Поменять местами нулевой элемент и элемент слева от него (метод Dice.swap(index, index - 1))
                    Dice.setIndexOfNull(index - 1)
            Если пользователь нажал кнопку "вниз"
                Проверить находится ли нулевой элемент в последних трех строчках (indexOfNull > 3)
                    Поменять местами нулевой элемент и элемент сверху от него (метод Dice.swap(index, index - 4))
                    Dice.setIndexOfNull(index - 4)
            Обновить кнопки (метод update)!!!
        */

        frame.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent event) {
                switch(event.getKeyCode())
                {
                    case KeyEvent.VK_LEFT:
                        if (Dice.indexOfNull % 4 != 3) {
                            Dice.swap(Dice.indexOfNull, Dice.indexOfNull + 1);
                            Dice.indexOfNull++;
                        }
                        break;
                    case KeyEvent.VK_UP:
                        if (Dice.indexOfNull < 12) {
                            Dice.swap(Dice.indexOfNull, Dice.indexOfNull + 4);
                            Dice.indexOfNull = Dice.indexOfNull + 4;
                        }
                        break;
                    case KeyEvent.VK_RIGHT:
                        if (Dice.indexOfNull % 4 != 0) {
                            Dice.swap(Dice.indexOfNull, Dice.indexOfNull - 1);
                            Dice.indexOfNull--;
                        }
                        break;
                    case KeyEvent.VK_DOWN:
                        if (Dice.indexOfNull > 3) {
                            Dice.swap(Dice.indexOfNull, Dice.indexOfNull - 4);
                            Dice.indexOfNull = Dice.indexOfNull - 4;
                        }
                        break;
                }
                update();
            }
        });
    }

    // Метод создания кнопок
    private void init(){
        // Цикл от 0 до 16 с созданием кнопок и добавлением на панель
        for (int i = 0; i < 16; i++) {
            // Создать кнопки в массиве buttons с именами, соответсвующими элементам массива dice
            buttons[i] = new JButton(String.valueOf(Dice.dice[i]));
            buttons[i].setFont(f);
            buttons[i].setFocusable(false);
            // Обработка событий, нажатие кнопки
                /*
                Получить имя кнопки
                Поменять местами элементы, если кнопка соседствует с нулевой (метод change)
                */
            buttons[i].addActionListener(e -> {
                JButton button = (JButton) e.getSource();
                if (Dice.change(Integer.parseInt(button.getText()))) {
                    update();
                }
            });
            // Добавить кнопку на панель
            add(buttons[i]);
        }
        buttons[Dice.indexOfNull].setVisible(false);
    }

    // Метод обновляет названия кнопок и их видимость
    public static void update() {
        // Цикл по массиву buttons
        for (int i = 0; i < 16; i++) {
            buttons[i].setText(String.valueOf(Dice.dice[i]));
            buttons[i].setVisible(true);
        }
        // После цикла кнопку с нулем скрыть
        buttons[Dice.indexOfNull].setVisible(false);
        // Проверить комбинацию на победу (метод win)
        if (Dice.win()) {
            JOptionPane.showMessageDialog(null, "Вы победили!");
            // Заново перетасовать (метод shuffle)
            Dice.shuffle();
            // Обновить кнопки (метод update)
            update();
        }
    }
}
