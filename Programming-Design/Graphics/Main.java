import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// Реализовать графическое приложение "Пятнашки"
public class Main {
    private int indexOfNull = 15; // индекс нулевого элемента
    private int[] dice = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 0}; // массив с числами от 0 до 15
    private final JButton[] buttons = new JButton[16]; // массив кнопок для отображения чисел
    private JFrame frame;
    private JPanel panel;
    private JMenuBar menu;

    public Main() {
        frame = new JFrame("Пятнашки"); // Создать новый контейнер типа JFrame и задать ему имя "Пятнашки"
        frame.setSize(280, 300); // Задать размеры фрейма (setSize)
        frame.setLocationRelativeTo(null);// Центрировать фрейм (setLocationRelativeTo(null))
        frame.setResizable(false); // Запретить менять размер фрейма (setResizable(false))
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Завершить работу, если пользователь закрывает приложение (setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE))

        // Добавить в фрейм обработку событий клавиатуры (addKeyListener)
        /*
            Если пользователь нажал кнопку "влево"
                Проверить находится ли нулевой элемент в первых трех столбцах (indexOfNull % 4 != 3)
                    Поменять местами нулевой элемент и элемент справа от него (метод swap(indexOfNull, indexOfNull + 1))
                    indexOfNull = indexOfNull + 1
            Если пользователь нажал кнопку "вверх"
                Проверить находится ли нулевой элемент в первых трех строчках (indexOfNull < 12)
                    Поменять местами нулевой элемент и элемент снизу от него (метод swap(indexOfNull, indexOfNull + 4))
                    indexOfNull = indexOfNull + 4
            Если пользователь нажал кнопку "вправо"
                Проверить находится ли нулевой элемент в последних трех столбцах (indexOfNull % 4 != 0)
                    Поменять местами нулевой элемент и элемент слева от него (метод swap(indexOfNull, indexOfNull - 1))
                    indexOfNull = indexOfNull - 1
            Если пользователь нажал кнопку "вниз"
                Проверить находится ли нулевой элемент в последних трех строчках (indexOfNull > 3)
                    Поменять местами нулевой элемент и элемент сверху от него (метод swap(indexOfNull, indexOfNull - 4))
                    indexOfNull = indexOfNull - 4
            Обновить кнопки (метод update)
        */
        frame.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent event) {
                switch(event.getKeyCode())
                {
                    case 37:
                        if (indexOfNull % 4 != 3) {
                            swap(indexOfNull, indexOfNull + 1);
                            indexOfNull = indexOfNull + 1;
                        }
                        break;
                    case 38:
                        if (indexOfNull < 12) {
                            swap(indexOfNull, indexOfNull + 4);
                            indexOfNull = indexOfNull + 4;
                        }
                        break;
                    case 39:
                        if (indexOfNull % 4 != 0) {
                            swap(indexOfNull, indexOfNull - 1);
                            indexOfNull = indexOfNull - 1;
                        }
                        break;
                    case 40:
                        if (indexOfNull > 3) {
                            swap(indexOfNull, indexOfNull - 4);
                            indexOfNull = indexOfNull - 4;
                        }
                        break;
                }
                update();
            }
        });

        // Создать и настроить меню (метод createMenu)
        createMenu();
        // Добавить меню в фрейм
        frame.setJMenuBar(menu);

        // Создать панель с диспетчером компоновки GridLayout
        panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4));
        // Перемешать кости, то есть случайным образом поменять местами элементы массива dice (метод shuffle)
        shuffle();
        // Цикл от 0 до 16 с созданием кнопок и добавлением на панель
        for (int i = 0; i < 16; i++) {
            // Создать кнопки в массиве buttons с именами, соответсвующими элементам массива dice
            buttons[i] = new JButton(String.valueOf(dice[i]));
            buttons[i].setFocusable(false);
            // Обработка событий, нажатие кнопки
                /*
                Получить имя кнопки
                Поменять местами элементы, если кнопка соседствует с нулевой (метод change)
                */
            buttons[i].addActionListener(e -> {
                JButton button = (JButton) e.getSource();
                change(Integer.parseInt(button.getText()));
            });
            // Добавить кнопку на панель
            panel.add(buttons[i]);
        }
        buttons[indexOfNull].setVisible(false);
        frame.add(panel);
        frame.setVisible(true);
    }

    // Метод создания меню
    public void createMenu() {
        // Создать строку меню
        menu = new JMenuBar();

        // Создать меню File
        JMenu jmFile = new JMenu("File"); //Файл
        jmFile.setMnemonic(KeyEvent.VK_F); // Задать мнемонику

        JMenuItem jmiNew = new JMenuItem("New"); // Новая игра
        jmiNew.setMnemonic(KeyEvent.VK_N); // Задать мнемонику
        jmiNew.setAccelerator(KeyStroke.getKeyStroke("ctrl N")); // Задать акселератор
        jmiNew.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                // Обновить массив dice
                dice = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 0};
                indexOfNull = 15;
                // Заново перетасовать (метод shuffle)
                shuffle();
                // Обновить кнопки (метод update)
                update();
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

        menu.add(jmFile);

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

        menu.add(jmHelp);
    }

    // Метод тасует все кости, кроме последней
    public void shuffle() {
        for (int i = 0; i < 15; i++) {
            // Случайное значение от i до 14
            int j = (int) (Math.random() * 15);
            // Поменять местами элементы i и j (метод swap(i, j))
            swap(i, j);
        }
    }

    // Метод меняет местами элементы массива dice с переданными индексами
    public void swap(int a, int b) {
        int temp = dice[a];
        dice[a] = dice[b];
        dice[b] = temp;
    }

    // Метод обновляет названия кнопок и их видимость
    public void update() {
        // Цикл по массиву buttons
        for (int i = 0; i < 16; i++) {
            buttons[i].setText(String.valueOf(dice[i]));
            buttons[i].setVisible(true);
        }
        // После цикла кнопку с нулем скрыть
        buttons[indexOfNull].setVisible(false);
        // Проверить комбинацию на победу (метод win)
        if (win()) {
            JOptionPane.showMessageDialog(null, "Вы победили!");
            // Обновить массив dice
            dice = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 0};
            indexOfNull = 15;
            // Заново перетасовать (метод shuffle)
            shuffle();
            // Обновить кнопки (метод update)
            update();
        }
    }

    // Метод проверяет соседствует ли элемент с нулевым
    // Если да, то вызывает методы swap и update
    // Если нет, ничего не делает
    public void change(int value) {
        int index = -1;
        // Цикл по массиву dice, чтобы найти индекс элемента value
        for(int i = 0; i < 16; i++)
            if (dice[i] == value)
                index = i;
        if (index + 1 == indexOfNull || index - 1 == indexOfNull || index + 4 == indexOfNull || index - 4 == indexOfNull) {
            swap(index, indexOfNull);
            indexOfNull = index;
            update();
        }
    }

    // Метод проверяет является ли текущая комбинация выигрышной
    public boolean win() {
        // Цикл от 0 до 15 по массиву dice с проверкой, что каждый элемент равен i + 1
        for (int i = 0; i < 15; i++)
            if (dice[i] != i + 1)
                return false;
        return true;
    }

    public static void main(String[] args) {
        new Main();
    }
}