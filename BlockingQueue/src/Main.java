import java.util.concurrent.*;

public class Main {
    static int cProducer = 0;
    static int cConsumer = 0;
    public static void main(String[] args) {
        int N;
        if (args.length > 0) {
            try {
                N = Integer.parseInt(args[0]);
                if (N < 1) {
                    System.err.println("Argument " + args[0] + " must be positive.");
                    System.exit(0);
                }
                ThreadFactory producerThread = r -> new Thread(r, "producer"+cProducer++);
                ThreadFactory consumerThread = r -> new Thread(r, "consumer"+cConsumer++);
                ExecutorService producer = Executors.newFixedThreadPool(N, producerThread);
                ExecutorService consumer = Executors.newFixedThreadPool(N, consumerThread);
                BlockingQueue<String> queue = new LinkedBlockingQueue<>();
                for (int i = 0; i < N; i++) {
                    consumer.execute(new Consumer(queue));
                    producer.execute(new Producer(queue));
                }
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                producer.shutdown();
                consumer.shutdownNow();
            } catch (NumberFormatException e) {
                System.err.println("Argument " + args[0] + " must be an integer.");
                System.exit(1);
            }
        }
    }
}
