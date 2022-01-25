import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Producer implements Runnable {
    private static final AtomicInteger count = new AtomicInteger(0);
    private final BlockingQueue<String> sharedQueue;

    public Producer(BlockingQueue<String> sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        try {
            Random random = new Random();
            int n = random.nextInt(5) + 3;
            System.out.println(Thread.currentThread().getName() + " will produce " + n + " elements");
            for (int i = 0; i < n; i++) {
                sharedQueue.put(produce());
                System.out.println(Thread.currentThread().getName() + " produced " + count.get() + " element");
                Thread.sleep(200);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " finished");
    }

    String produce() {
        return Thread.currentThread().getName() + "_element" + count.incrementAndGet();
    }
}
