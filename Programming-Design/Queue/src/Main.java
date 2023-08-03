public class Main {
    public static void main(String[] args) throws InterruptedException {
        PQ pq = new PQ();

        Consumer consumer1 = new Consumer(pq, 1);
        Consumer consumer2 = new Consumer(pq, 2);

        Producer producer1 = new Producer(pq, 1);
        Producer producer2 = new Producer(pq, 2);
    }
}
