// класс производителя
public class Producer implements Runnable {
    private final PQ pq;

    public Producer(PQ pq, int id){
        // инициализировать очередь
        this.pq = pq;
        // создать поток
        Thread producer = new Thread(this);
        // задать потоку имя
        producer.setName("Производитель " + id);
        // запустить поток
        producer.start();
    }

    public void run() {
        try {
            while(true) {
                // генерация количества итераций
                // цикл, генерация значений и добавление их в очередь (метод insert)
                int k = (int) (Math.random() * 3) + 1;
                for (int i = 0; i <= k; i++) {
                    pq.insert((int) (Math.random() * 10) + 1);
                }
                Thread.sleep(500);
            }
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}