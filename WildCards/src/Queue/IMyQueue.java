package Queue;

public interface IMyQueue<T> {
    void add(T obj) throws QueueFullException;

    T get() throws QueueEmptyException;
}
