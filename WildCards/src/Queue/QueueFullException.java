package Queue;

public class QueueFullException extends Exception {
    private int size;

    public QueueFullException(int size) {
        this.size = size;
    }

    public String toString() {
        return "Queue is full. Capacity of queue is " + size + " elements";
    }
}
