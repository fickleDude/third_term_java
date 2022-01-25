import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;


public class ThreadPoolConsumer implements ThreadFactory {
    private static final AtomicInteger id = new AtomicInteger(0);

    @Override
    public Thread newThread(Runnable r) {
        return new Thread(r, "consumer"+id.getAndIncrement());
    }
}
