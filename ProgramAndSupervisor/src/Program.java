public class Program extends Thread {
    private MyState programState;
    private final Daemon daemon;
    private boolean changed;
    private final Object mutex;


    public Program(Object mutex) {
        programState = MyState.RUNNING;
        this.mutex = mutex;
        daemon = new Daemon(this, mutex);
        changed = true;
    }

    public MyState getProgramState() {
        return programState;
    }

    public void setProgramState(MyState state) {
        programState = state;
    }

    public boolean isChanged() {
        return changed;
    }

    public void setChanged(boolean changed) {
        this.changed = changed;
    }

    public Daemon getDaemon() {
        return daemon;
    }

    @Override
    public void run() {
        System.out.println("program on");
        daemon.start();
        while (!isInterrupted()) {
//            try {
//                //имитируем работу(для того, что бы избежать thread starvation)
//                System.out.println("program is running");
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                System.out.println("program off");
//                interrupt();
//            }
        }
        System.out.println("program off");
    }
}