package Realization;

import java.util.Objects;

//Реализовать класс строки: строка - связный список
public class ListString
{
    // Класс блока: узла связного списка
    private class StringItem
    {
        private final static int SIZE = 16; // размер символьного массива в блоке
        private char [] symbols; // символьный массив
        private StringItem next; // следующий блок
        private int size; // реальный размер символьного массива в блоке

        // Конструктор по умолчанию
        private StringItem()
        {
            symbols = new char[SIZE];
            size = 0;
            next = null;
        }

        // Копирующий конструктор
        private StringItem(StringItem si)
        {
            this();
            if (si != null)
            {
                copy(si.symbols, symbols, 0, 0, si.size);
                size = si.size;
            }
        }

        // Совместить два соседних блока в один
        private void join()
        {
            copy(next.symbols, symbols, 0, size, next.size); // Скопировать значения из следущего блока в текущий (метод copy)
            size += next.size; // Обновить size
            next = next.next; // Текущий next приравнивается следующему
        }

        // Разделить блок на два, начиная с index
        private void split(int index)
        {
            StringItem block = new StringItem(); // Создать новый блок
            copy(symbols, block.symbols, index, 0, this.size - index); // Скопировать значения, начиная с index, в следующий блок (метод copy)
            block.size = this.size - index;
            block.next = next; // Next нового блока приравнивается next текущего
            next = block; // Next текущего приравнивается новому блоку
            this.size = index;
        }
    }

    // Класс индекса: блок и позиция в нем
    private class Index
    {
        private StringItem si; //ссылка на блок
        private int position; //позиция элемента в массиве

        // Конструктор из блока и позиции
        private Index (StringItem si, int position)
        {
            this.si = si;
            this.position = position;
        }
    }

    private StringItem head; // начало связного списка

    //Конструктор по умолчанию
    public ListString()
    {
        head = null;
    }

    //Конструктор из ListString
    public ListString(ListString ls)
    {
        if (ls != null) {
            head = new StringItem(ls.head); // Инициализация переменной head равной ls.head (копирующий конструктор)
            // Создать два узла StringItem (old: ls.head, new: head)
            StringItem oldBlock = ls.head;
            StringItem newBlock = head;
            // Пока элемент есть, двигаться по данному связному списку и создавать новые узлы в текущий список (копирующий конструктор)
            while (oldBlock != null) {
                newBlock.next = new StringItem(oldBlock.next);
                newBlock = newBlock.next;
                oldBlock = oldBlock.next;
            }
        } else {
            head = new StringItem();
        }
    }

    //Конструктор из строки
    public ListString(String c)
    {
        if (Objects.equals(c, ""))
            head = null;
        else {
            head = new StringItem();
            StringItem h = head;
            int i, j, ost;
            char[] c2 = c.toCharArray(); // создаем массив char с данной нам строкой
            ost = (c.length() % StringItem.SIZE == 0) ? 0 : 1;
            for (i = 0; i < c.length() / StringItem.SIZE + ost; i++) {
                h.next = new StringItem();
                for (j = 0; c.length() > (i * StringItem.SIZE + j) && j < StringItem.SIZE; j++)
                    h.next.symbols[j] = c2[i * StringItem.SIZE + j];
                h.next.size = j;
                h = h.next;
            }
        }
    }

    // Найти фактическую длину связного списка, совмещая при этом полупустые блоки
    public int length()
    {
        if (head == null)
            return 0;
        int len = 0;
        StringItem block = head;
        while (block != null)
        {
            if (block.next != null && block.size + block.next.size <= StringItem.SIZE)
                block.join();
            else
            {
                len += block.size;
                block = block.next;
            }
        }
        return len;
    }

    // Найти символ по индексу
    public char charAt(int index) throws IndexException
    {
        if (index > -1) {
            Index i = find(index); // Найти блок и позицию в этом блоке (метод find)
            if (i.position == -1) // Если позиция не действительна, выбросить исключение
                throw new IndexException(index);
            if (i.si == null) // Если блок == null, значит, что позиция в head, вернуть head.symbols[позиция]
                return head.symbols[i.position];
            else // Иначе вернуть символ: блок.next.symbols[позиция]
                return i.si.next.symbols[i.position];
        } else {
            throw new IndexException(index);
        }
    }

    // Заменить в строке символ в позиции index на символ ch
    public void setCharAt(int index, char ch) throws IndexException
    {
        if (index > -1) {
            Index i = find(index); // Найти блок и позицию в этом блоке (метод find)
            if (i.position == -1) // Если позиция не действительна, выбросить исключение
                throw new IndexException(index);
            if (i.si == null) // Если блок == null, значит, что позиция в head, head.symbols[позиция] = ch
                head.symbols[i.position] = ch;
            else // блок.next.symbols[позиция] = ch
                i.si.next.symbols[i.position] = ch;
        } else {
            throw new IndexException(index);
        }
    }

    // Создать новый ListString (подстрока от start до end текущего)
    public ListString substring(int start, int end) throws IndexException
    {
        if (start == end)
            return new ListString(String.valueOf(charAt(start))); // Если начало и конец равны, вернуть символ в этой позиции
        if (start > -1 && end > -1) {
            // Если конец меньше старта, выбросить исключение
            if (end <= start)
                throw new IndexException();
            Index start_index = find(start); // Найти блок и позицию для start (метод find)
            // Если старта не существует, выбросить исключение
            if (start_index.position == -1)
                throw new IndexException(start);
            Index end_index = find(end); // Найти блок и позицию для end (метод find)
            // Если конца не существует, брать до конца строки (меняем блок end (метод lastItem), индекс на размер этого блока)
            if (end_index.position == -1) {
                end_index.si = this.lastItem();
                end_index.position = end_index.si.size - 1;
            } else {
                // Проверить не является ли блок head
                if (end_index.si == null)
                    end_index.si = head;
                else
                    end_index.si = end_index.si.next;
            }

            // Проверить не является ли блок head
            if (start_index.si == null)
                start_index.si = head;
            else
                start_index.si = start_index.si.next;

            // Создание подстроки с пустым единственным блоком
            ListString sub = new ListString();
            sub.head = new StringItem();

            // Если начало и конец в одном блоке, создать один узел и скопировать в него символьный массив (метод copy)
            if (start_index.si == end_index.si) {
                sub.head.size = end_index.position - start_index.position + 1;
                copy(start_index.si.symbols, sub.head.symbols, start_index.position, 0, sub.head.size);
            }

            // Если начало и конец в разных блоках
            /*
                Блок start копируется частично (метод copy от start до конца)
                Цикл по блокам до блока end
                Новые узлы создавать копирующим конструктором new StringItem(StringItem)
                Блок end копируется частично ((метод copy от 0 до end)
             */
            else {
                StringItem currentBlock = start_index.si; // Блок в исходной строке-списку
                StringItem blockInSub = sub.head; // Блок в подстроке
                blockInSub.size = currentBlock.size - start_index.position; // Размер первого блока подстроки
                copy(currentBlock.symbols, blockInSub.symbols, start_index.position, 0, blockInSub.size); // Копирование первого блока

                currentBlock = currentBlock.next;
                //Пока не дойдём до конечного блока, просто копируем
                while (currentBlock != end_index.si) {
                    blockInSub.next = new StringItem(currentBlock);
                    blockInSub = blockInSub.next;
                    currentBlock = currentBlock.next;
                }

                blockInSub.next = new StringItem(); // Последний блок
                blockInSub = blockInSub.next;
                blockInSub.size = end_index.position + 1; // Размер последнего блока в подстроке

                // Копирование последнего блока
                copy(end_index.si.symbols, blockInSub.symbols, 0, 0, blockInSub.size);
            }
            return sub;
        } else if (start <= -1) throw new IndexException(start);
        else throw new IndexException(end);
    }

    // Дойти до последнего блока
    private StringItem lastItem()
    {
        StringItem currentBlock = head;
        StringItem previousBlock = null;
        // Пока есть следующий блок двигаться по связному списку
        while (currentBlock != null)
        {
            previousBlock = currentBlock;
            currentBlock = currentBlock.next;
        }
        return previousBlock; // Вернуть элемент, у которого next null
    }

    // Добавить в конец строки символ
    public void append(char ch)
    {
        if (head == null)
            head = new StringItem();
        StringItem lastBlock = this.lastItem(); // Получить последний блок (метод lastItem)
        /*
        Проверить если в нем место
        True: добавить элемент в текущий массив
        False: создать следующий блок и записать в него этот символ
        */
        if (lastBlock.size < StringItem.SIZE) {
            lastBlock.symbols[lastBlock.size] = ch;
            lastBlock.size += 1;
        } else {
            lastBlock.next = new StringItem();
            lastBlock.next.symbols[0] = ch;
            lastBlock.size = 1;
        }
    }

    // Добавить в конец строку ListString
    public void append(ListString string)
    {
        if (string.head == null)
            return;
        if (head == null)
            head = new StringItem();
        ListString s = new ListString(string); // Копирование добавляемой строки
        StringItem lastBlock = this.lastItem(); // Получить последний блок (метод lastItem)
        lastBlock.next = s.head; // Перекинуть указатель next на string.head
    }

    // Добавить в конец строку String
    public void append(String string)
    {
        if (string.equals(""))
            return;
        if (head == null)
            head = new StringItem();
        ListString ls = new ListString(string); // Преобразовать строку в список-строку new ListString(string)
        StringItem lastBlock = this.lastItem(); // Получить последний блок (метод lastItem)
        lastBlock.next = ls.head; // Перекинуть указатель next на string.head
    }

    // Вставить в строку в позицию index строку ListString
    public void insert(int index, ListString string) throws IndexException
    {
        if (string.head == null)
            return;
        if (head == null)
            head = new StringItem();
        if (index > -1) {
            Index i = find(index); // Найти предыдущий блок от нужного и позицию для индекса (метод find)
            // Если индекс недействителен, выбросить исключение
            if (i.position == -1)
                throw new IndexException(index);

            ListString s = new ListString(string);
            insert(i, s);
        } else throw new IndexException(index);
    }

    // Вставить в строку в позицию index строку String
    public void insert(int index, String s) throws IndexException
    {
        if (s.equals(""))
            return;
        if (head == null)
            head = new StringItem();
        if (index > -1) {
            Index i = find(index); // Найти предыдущий блок от нужного и позицию для индекса (метод find)
            // Если индекс недействителен, выбросить исключение
            if (i.position == -1)
                throw new IndexException(index);

            // Преобразовать строку в список-строку new ListString(string)
            ListString string = new ListString(s);
            insert(i, string);
        } else throw new IndexException(index);
    }

    // insert закрытый с готовым индексом и строкой
    private void insert(Index index, ListString string)
    {
        if (head == null)
            head = new StringItem();
        StringItem lastBlock = string.lastItem(); // Последний блок вставляемой строки
        // Если возвращенный блок == null, то нужный блок head
        if (index.si == null) {
            // Если блок head и индекс 0, перекинуть указатели
            if (index.position == 0) {
                lastBlock.next = head;
                head = string.head;
            }
            // Иначе если блок head, разделить (метод split) и перебросить указатели
            else {
                head.split(index.position);
                lastBlock.next = head.next; // Присоединение правой части расщеплённого блока к вставляемому блоку
                this.head.next = string.head; // Вставка нового узла
            }
        }
        else
        {
            // Если индекс 0, перекинуть указатели
            if (index.position == 0)
            {
                lastBlock.next = index.si.next;
                index.si.next = string.head;
            }
            // Иначе нужный блок разделить по позиции (метод split) и перебросить указатели
            else
            {
                index.si.next.split(index.position);
                lastBlock.next = index.si.next.next; // Присоединение правой части расщеплённого блока к вставляемому узлу
                index.si.next.next = string.head; // Вставка нового узла
            }
        }
    }

    // Преобразовать список-строку в строку
    public String toString()
    {
        int len = this.length(); // Узнать длину списка-строки
        int filledChars = 0;
        char[] charArray = new char[len]; // Выделить память под символьный массив
        // Скопировать туда каждый узел списка-строки (цикл с методом copy)
        StringItem block = head;
        while (block != null)
        {
            copy(block.symbols, charArray,0, filledChars, block.size);
            filledChars += block.size;
            block = block.next;
        }
        return new String(charArray); // Вернуть new String(полученный символьный массив)
    }

    // Найти блок и позицию элемента по индексу
    private Index find(int i)
    {
        // Создать переменные для учета текущего блока и предыдущего.
        StringItem currentBlock = head;
        StringItem pastBlock = null;

        while (currentBlock != null)
        {
            // Если i больше размера текущего блока, то i -= size, иначе break
            if (i >= currentBlock.size)
                i -= currentBlock.size;
            else
                return new Index(pastBlock, i);
            // Предыдущий блок заменяем на текущий, а текущий на следующий
            pastBlock = currentBlock;
            currentBlock = currentBlock.next;
        }
        return new Index(null, -1);
    }

    // Скопировать элементы одного символьного массива в другой
    private static void copy(char[] from, char[] to, int old_start, int new_start, int length)
    {
        for(int i = 0; i < length; i++)
            to[new_start + i] = from[old_start + i];
    }
}