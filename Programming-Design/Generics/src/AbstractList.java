// обобщенный класс АТД “Список”
class AbstractList<T extends Comparable<T>>{
    private T[] list; // массив элементов заданного типа
    private int afterTheLast = 0; // номер первого свободного элемента

    // конструктор из массива
    public AbstractList(T[] list){
        this.list = list;
    }

    // Позиция после последнего
    public int End(){
        return afterTheLast;
    }

    // Вставка значения x в позицию p списка L
    public void Insert(T x, int p){
        // если позиция меньше нуля или больше позиции после последней, то ничего не делать
        if (p < 0 || p > afterTheLast)
            return;
        // иначе цикл от позиции после последней до нужной (i--) list[i] = list[i-1]
        for (int i = afterTheLast; i > p; i--) {
            list[i] = list[i - 1];
        }
        // после цикла list[p] = x;
        list[p] = x;
        // afterTheLast увеличить на 1
        afterTheLast++;
    }

    // Позиция p значения x в списке L
    public int Locate(T x){
        // цикл по списку и сравнение значений (метод compareTo)
        for (int i = 0; i < afterTheLast; i++)
        // если в цикле есть равенство, то вернуть нужную позицию
            if (list[i].compareTo(x) == 0)
                return i;
        return afterTheLast;
    }

    // Значение позиции p списка L
    public T Retrieve(int p){
        // если позиция недействительна или это позиция после последнего, выбросить исключение
        if (p < 0 || p >= afterTheLast)
            throw new RuntimeException();
        // иначе вернуть list[p];
        else
            return list[p];
    }

    // Удаление значения позиции p списка L
    public void Delete(int p){
        // если позиция недействительна или это позиция после последнего, ничего не делать
        if (p < 0 || p >= afterTheLast)
            return;
        // иначе цикл от нужной позиции до конца (значение текущего элемента приравнивается значению следующего)
        for (int i = p; i < afterTheLast - 1; i++)
            list[i] = list[i + 1];
        // уменьшить afterTheLast на 1
        afterTheLast--;
    }

    // Позиция следующая за p в списке L
    public int Next(int p){
        if (p >= afterTheLast || p < 0)
            throw new RuntimeException();
        return p+1;
    }

    // Предыдущая позиция за p в списке L
    public int Previous(int p){
        if (p >= afterTheLast || p <= 0)
            throw new RuntimeException();
        return p-1;
    }

    // Опустошение списка
    public void MakeNull(){
        // позицию после последнего сделать нулевой
        afterTheLast = 0;
    }

    // Позиция первого элемента в списке
    public int First(){
        return 0;
    }

    // Вывод на печать заполненной части списка L
    public void PrintList(){
        // цикл по списку
        for (int i = 0; i < afterTheLast - 1; i++)
            System.out.print(list[i] + ", ");
        System.out.print(list[afterTheLast - 1]);
        System.out.println();
    }
}