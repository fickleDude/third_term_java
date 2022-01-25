package Queue;

import java.util.Queue;

public class MyQueue<T> implements IMyQueue<T> {
    private Queue<T> data;
    private int putloc, getloc;

    public MyQueue(Queue<T> data) {
        this.data = data;
        putloc = data.size();
        getloc = 0;
    }

    @Override
    public void add(T obj) throws QueueFullException {
        if (putloc == data.size() - 1) {
            throw new QueueFullException(data.size());
        }
        data.offer(obj);
        putloc++;
    }


    @Override
    public T get() throws QueueEmptyException {
        if (getloc == putloc) {
            throw new QueueEmptyException();
        }
        getloc++;
        return data.poll();

    }

    @Override
    public String toString() {
        return data.toString();
    }

    public boolean empty() {
        return putloc == getloc;
    }

}
