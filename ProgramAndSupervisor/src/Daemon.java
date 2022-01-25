import java.util.Random;

class Daemon extends Thread {
    private final Program program;
    private final Object mutex;

    public Daemon(Program program, Object mutex) {
        this.program = program;
        this.mutex = mutex;
        setDaemon(true);
    }

    @Override
    public void run() {
        while (program.isAlive()) {
            synchronized (mutex) {
                while (program.isChanged()) {
                    try {
                        mutex.wait();
                    } catch (InterruptedException e) {
                        return;
                    }
                }
                System.out.println("changing state");
                program.setProgramState(generateState());
                program.setChanged(true);
                mutex.notify();
            }
        }
    }

    private MyState generateState() {
        Random random = new Random();
        return switch (random.nextInt(4)) {
            case 1 -> MyState.UNKNOWN;
            case 2 -> MyState.STOPPING;
            case 3 -> MyState.FATAL_ERROR;
            default -> MyState.RUNNING;
        };
    }
}