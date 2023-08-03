import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class PQ implements PriorityQueue {
    // Очередь реализована на массиве размера 10
    private static final int SIZE = 10;
    private final Integer[] array = new Integer[SIZE];
    private int afterTheLast = 0;
    private final ReentrantLock lock;
    Condition emptyCondition, fullCondition, first, second;

    public PQ() {
        // инициализация лока и условий
        lock = new ReentrantLock();
        emptyCondition = lock.newCondition();
        fullCondition = lock.newCondition();
        first = lock.newCondition();
        second = lock.newCondition();
    }

    @Override
    public void insert(int val) throws InterruptedException {
        lock.lock();
        try {
            // пока очередь полная (метод full)
            while (full())
                // заблокировать поток по условию fullCondition (fullCondition.await())
                fullCondition.await();
            // добавить значение в последний свободный элемент
            array[afterTheLast++] = val;

            int added = afterTheLast - 1; // последний добавленный

            while (added > 0 && array[added] > array[(added-1)/2]) { // отсортировать очередь
                swap(added, (added-1)/2); // поменять сына и родителя местами
                added = ((added-1)/2); // поменять индекс последнего добавленного
            }

            print();
            emptyCondition.signalAll();
            first.signalAll();
            second.signalAll();
        } finally {
            lock.unlock();
        }
    }

    @Override
    public int deleteMax() throws InterruptedException {
        lock.lock();
        try {
            // пока очередь пустая (метод empty)
            while (empty())
                // заблокировать поток по условию emptyCondition (emptyCondition.await())
                emptyCondition.await();

            // если действует второй поток, то пока значение меньше 5 заблокировать поток по второму условию и дать сигнал по первому
            if (Thread.currentThread().getName().equals("Потребитель 2"))
                while (array[0] < 6){
                    second.await();
                    first.signal();
                }
            // если действует первый поток, то пока значение больше 5 заблокировать поток по первому условию и дать сигнал по второму
            else
                while (array[0] >= 6){
                    first.await();
                    second.signal();
                }

            // поменять первый и последний заполненный элементы местами
            swap(0, afterTheLast - 1);
            Integer result = array[afterTheLast - 1];
            // обнулить последний заполненный элемент
            array[--afterTheLast] = null;
            // отсортировать очередь (метод sort)
            int current = 0;
            while(current * 2 + 1 < afterTheLast){ // пока есть сыновья
                int max;
                int left = current * 2 + 1; // левый сын
                int right = current * 2 + 2; // правый сын
                if(right < afterTheLast && array[right] > array[left]){ // поиск максимального значения
                    max = right;
                }
                else{
                    max = left;
                }
                if(array[current] < array[max]){ // смена позиций
                    swap(current, max);
                    current = max;
                }
                else{
                    break; // завершение перебора
                }
            }
            print();
            fullCondition.signalAll();
            return result;
        } finally {
            lock.unlock();
        }
    }

    @Override
    public boolean full() {
        return afterTheLast == 10;
    }

    @Override
    public boolean empty() {
        return afterTheLast == 0;
    }

    private void swap(int i, int j) {
        Integer temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private void print(){
        System.out.print(Thread.currentThread().getName() + ": ");
        for (int i = 0; i < afterTheLast; i++)
            System.out.print(array[i] + " ");
        System.out.println();
    }
}
