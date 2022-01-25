import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;


public class ThreadPoolProducer implements ThreadFactory {
    private static final AtomicInteger id = new AtomicInteger(0);

    @Override
    public Thread newThread(Runnable r) {
        return new Thread(r, "producer"+id.getAndIncrement());
    }
}
