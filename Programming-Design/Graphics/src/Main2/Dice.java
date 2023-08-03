package Main2;

// Класс самой игры, реализованный на одномерном массиве
public class Dice {
    public static int indexOfNull = 15; // индекс нулевого элемента
    public static int[] dice = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 0}; // массив с числами от 0 до 15

    // Метод тасует все элементы, кроме последнего
    public static void shuffle() {
        for (int i = 0; i < 15; i++) {
            // Случайное значение от i до 14
            int j = (int) (Math.random() * 15);
            swap(i, j);
        }
    }

    // Метод меняет местами элементы массива dice с переданными индексами
    public static void swap(int a, int b) {
        int temp = dice[a];
        dice[a] = dice[b];
        dice[b] = temp;
    }

    // Метод проверяет является ли текущая комбинация выигрышной
    public static boolean win() {
        // Цикл от 0 до 15 по массиву dice с проверкой, что каждый элемент равен i + 1
        for (int i = 0; i < 15; i++)
            if (dice[i] != i + 1)
                return false;
        return true;
    }

    // Метод проверяет соседствует ли элемент с нулевым
    // Если да, то меняет местами элементы (метод swap), меняет индекс нуля и возвращает true
    // Если нет, возвращает false
    public static boolean change(int value) {
        int[] neighbours = {(indexOfNull - 4 >= 0) ? (indexOfNull - 4) : indexOfNull,
                            (indexOfNull + 4 <= 15) ? (indexOfNull + 4) : indexOfNull,
                            (indexOfNull - 1 >= 0) ? (indexOfNull - 1) : indexOfNull,
                            (indexOfNull + 1 <= 15) ? (indexOfNull + 1) : indexOfNull };
        for (int i = 0; i < 4 ; i++)
            if (dice[neighbours[i]] == value) {
                swap(neighbours[i], indexOfNull);
                indexOfNull = neighbours[i];
                return true;
            }
        return false;
    }
}