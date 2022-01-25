import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Consumer implements Runnable {
    private final BlockingQueue<String> sharedQueue;

    public Consumer(BlockingQueue<String> sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                consume(sharedQueue.take());
                Thread.sleep(400);
            }
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " was interrupted");
        }
        System.out.println(Thread.currentThread().getName() + " finished");
    }

    void consume(String obj) {
        System.out.println(Thread.currentThread().getName() + " consumed " + obj);
    }
}