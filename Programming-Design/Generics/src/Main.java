// главный класс
public class Main {
    public static void main(String[] args){
        // создание и заполнение списков
        AbstractList<Integer> first = new AbstractList<>(new Integer[10]);
        first.Insert(4, 0);
        first.Insert(4, 1);
        first.Insert(4, 2);
        first.Insert(4, 3);
        first.Insert(4, 4);
        first.PrintList();

        AbstractList<Rational> second = new AbstractList<>(new Rational[10]);
        second.Insert(new Rational(-5, 10), 0);
        second.Insert(new Rational(-1, 2), 1);
        second.Insert(new Rational(3, 10), 2);
        second.Insert(new Rational(-30, 11), 3);
        second.Insert(new Rational(6, -1), 4);
        second.PrintList();

        AbstractList<String> third = new AbstractList<>(new String[10]);
        third.Insert("1", 0);
        third.Insert("1", 1);
        third.Insert("1", 2);
        third.PrintList();

        // удаление одинаковых элементов (метод deleteDupes)
        deleteDupes(first);
        deleteDupes(second);
        deleteDupes(third);

        // вывод после удаления дубликатов
        first.PrintList();
        second.PrintList();
        third.PrintList();
    }

    // обобщенный статический метод удаления дубликатов из списка
    public static <T extends Comparable<T>> void deleteDupes(AbstractList<T> list){
        // Найти первую позицию в списке (метод First)
        int current = list.First();
        // Пока эта позиция не равна последней (метод End)
        while (current != list.End()){
            // Найти следующую позицию (метод Next)
            int next = list.Next(current);
            // Пока следующая позиция не равна последней (метод End)
            while (next != list.End())
            // Если значения на этих позициях равны (методы Retrieve и compareTo)
                if (list.Retrieve(current).compareTo(list.Retrieve(next)) == 0)
                    // Удалить повторение (метод Delete)
                    list.Delete(next);
                else
                    // Обновить следующую позицию (метод Next)
                    next = list.Next(next);
            // Обновить текущую позицию (метод Next)
            current = list.Next(current);
        }
    }
}
