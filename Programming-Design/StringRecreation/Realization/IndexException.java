package Realization;

//Реализовать класс исключения
public class IndexException extends RuntimeException
{
    int index; // в каком индексе ошибка

    // Конструктор исключения
    public IndexException(){}

    public IndexException(int index)
    {
        this.index = index;
    }

    // Сообщение ошибки
    public String toString()
    {
        return "Неверный индекс " + index;
    }
}