// класс потребителя
public class Consumer implements Runnable {
    private final PQ pq;
    private int id;

    public Consumer(PQ pq, int id){
        // инициализировать очередь
        this.pq = pq;
        // инициализировать верхнюю границу
        this.id = id;
        // создать поток
        Thread consumer = new Thread(this);
        // задать потоку имя
        consumer.setName("Потребитель " + id);
        // запустить поток
        consumer.start();
    }

    public void run() {
        while (true) {
            try {
                pq.deleteMax(); // удаление значения из очереди
                Thread.sleep(500); //задержка
            }
            catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }
    }
}